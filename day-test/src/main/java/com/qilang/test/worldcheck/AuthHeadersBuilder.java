package com.qilang.test.worldcheck;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static java.time.ZoneOffset.UTC;
import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;

public class AuthHeadersBuilder {

    private static final String HMAC_SHA_256 = "HmacSHA256";

    private static final String CONTENT_TYPE_PREFIX = "application/json";

    private static final String SIGNATURE_HEADERS_WITHOUT_CONTENT = "(request-target) host date";

    private static final String SIGNATURE_HEADERS_WITH_CONTENT = "(request-target) host date content-type content-length";

    private AuthHeadersBuilder() {
    }

    /**
     * Generates a {@link Map} with required authorization headers (Date, Authorization).
     *
     * @param apiKey     the user's API key
     * @param apiSecret  the user's API secret
     * @param httpMethod the HTTP method of a request (e.g. 'get', 'options', 'head', 'post', 'put', 'patch',
     *                   or 'delete')
     * @param uri        the {@link URI} to send the request to (e.g. 'https://www.example.com/resources')
     * @return {@link Map} with all required headers for authorization (Date, Authorization)
     */
    public static Map<String, String> generateAuthHeaders(String apiKey, String apiSecret, String httpMethod, URI uri) {
        return generateAuthHeaders(apiKey, apiSecret, httpMethod, uri, null, null);
    }

    /**
     * Generates a {@link Map} with required authorization headers (Date, Authorization, Content-Type, Content-Length).
     *
     * @param apiKey     the user's API key
     * @param apiSecret  the user's API secret
     * @param httpMethod the HTTP method of a request (e.g. 'get', 'options', 'head', 'post', 'put', 'patch',
     *                   or 'delete')
     * @param uri        the {@link URI} to send the request to (e.g. 'https://www.example.com/resources')
     * @param payload    payload/body of the request
     * @return {@link Map} with all required headers for authorization (Date, Authorization, Content-Type,
     * Content-Length)
     */
    public static Map<String, String> generateAuthHeaders(String apiKey,
                                                          String apiSecret,
                                                          String httpMethod,
                                                          URI uri,
                                                          String contentType,
                                                          String payload) {
        validateContentType(contentType, payload);

        Map<String, String> authHeaders = new HashMap<>();

        String date = ZonedDateTime.now(UTC).format(RFC_1123_DATE_TIME);

        StringBuilder dataToSign = new StringBuilder(300)
            .append("(request-target): ").append(httpMethod.toLowerCase()).append(' ').append(uri.getPath())
            .append("\nhost: ").append(uri.getHost())
            .append("\ndate: ").append(date);

        if (payload != null) {
            int contentLength = payload.getBytes().length;
            dataToSign.append("\ncontent-type: ").append(contentType)
                      .append("\ncontent-length: ").append(contentLength)
                      .append('\n').append(payload);
            authHeaders.put("Content-Type", contentType);
            authHeaders.put("Content-Length", String.valueOf(contentLength));
        }

        String headers = payload == null ? SIGNATURE_HEADERS_WITHOUT_CONTENT : SIGNATURE_HEADERS_WITH_CONTENT;
        String signature = signDataWithHmacSha256(apiSecret, dataToSign.toString());

        String authorization = "Signature keyId=\"" + apiKey +
                               "\",algorithm=\"hmac-sha256\",headers=\"" + headers +
                               "\",signature=\"" + signature + '"';

        authHeaders.put("Date", date);
        authHeaders.put("Authorization", authorization);

        return authHeaders;
    }

    private static void validateContentType(String contentType, String payload) {
        if (contentType != null && !contentType.startsWith(CONTENT_TYPE_PREFIX)) {
            throw new IllegalArgumentException("Unsupported content type " + contentType);
        }

        if (contentType != null && payload == null) {
            throw new IllegalArgumentException("The request payload(body) has not been provided");
        }

        if (contentType == null && payload != null) {
            throw new IllegalArgumentException("The content type of request payload(body) has not been provided");
        }
    }

    private static String signDataWithHmacSha256(String apiSecret, String dataToSign) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA_256);
            mac.init(new SecretKeySpec(apiSecret.getBytes(), HMAC_SHA_256));

            byte[] hmac = mac.doFinal(dataToSign.getBytes());

            return Base64.getEncoder().encodeToString(hmac);
        } catch (NoSuchAlgorithmException | IllegalArgumentException | InvalidKeyException e) {
            throw new RuntimeException(format("Unable to sign user: %s with data: %n%s", apiSecret, dataToSign), e);
        }
    }
}
