package model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 消息体
 *
 * @author hql
 */
public abstract class MessageBody implements Serializable {

    private static final long serialVersionUID = 7806172252641094611L;

    public abstract String getMessageType();

    /**
     * 消息体：文本消息
     */
    @Getter
    @Setter
    public static class TextBody extends MessageBody implements Serializable {

        private static final long serialVersionUID = -1154178316427891270L;

        /**
         * 消息内容,建议500字符以内
         */
        private String content;

        public TextBody(String content) {
            this.content = content;
        }

        @Override
        public String getMessageType() {
            return "";
        }
    }

    /**
     * 消息体：Markdown消息
     */
    @Getter
    @Setter
    public static class MarkdownBody extends MessageBody implements Serializable {

        private static final long serialVersionUID = 662472936435903055L;

        /**
         * 首屏会话透出的展示内容
         */
        private String title;
        /**
         * markdown格式的消息,建议500字符以内
         */
        private String text;

        public MarkdownBody(String title) {
            this.title = title;
        }

        public MarkdownBody text(String text) {
            this.text = text;
            return this;
        }

        @Override
        public String getMessageType() {
            return "";
        }
    }

    /**
     * 消息体：文件消息
     */
    @Getter
    @Setter
    @SuppressWarnings("squid:S00116")
    public static class FileBody extends MessageBody implements Serializable {

        private static final long serialVersionUID = 3585764347305914798L;

        /**
         * 媒体文件ID,引用的媒体文件最大10MB,可以通过上传媒体文件接口获取
         */
        private String media_id;

        public FileBody(String mediaId) {
            this.media_id = mediaId;
        }

        @Override

        public String getMessageType() {
            return "";
        }
    }

    /**
     * 消息体：图片消息
     */
    @Getter
    @Setter
    @SuppressWarnings("squid:S00116")
    public static class ImageBody extends MessageBody implements Serializable {

        private static final long serialVersionUID = 5938559411331850057L;

        /**
         * 媒体文件media_id,可以通过上传媒体文件接口获取,建议宽600像素x400像素,宽高比3:2
         */
        private String media_id;

        public ImageBody(String mediaId) {
            this.media_id = mediaId;
        }

        @Override

        public String getMessageType() {
            return "";
        }
    }

    /**
     * 消息体：语音消息
     */
    @Getter
    @Setter
    @SuppressWarnings("squid:S00116")
    public static class VoiceBody extends MessageBody implements Serializable {

        private static final long serialVersionUID = -2912384170980498468L;

        /**
         * 媒体文件ID,可以通过上传媒体文件接口获取,建议宽600像素x400像素,宽高比3:2
         */
        private String media_id;
        /**
         * 正整数,小于60,表示音频时长
         */
        private String duration;

        public VoiceBody(String mediaId) {
            this.media_id = mediaId;
        }

        public VoiceBody duration(String duration) {
            this.duration = duration;
            return this;
        }

        @Override
        public String getMessageType() {
            return "";
        }
    }

    /**
     * 消息体：链接消息
     */
    @Getter
    @Setter
    public static class LinkBody extends MessageBody implements Serializable {

        private static final long serialVersionUID = 8568027947229962361L;

        /**
         * 消息标题,建议100字符以内
         */
        private String title;
        /**
         * 消息描述,建议500字符以内
         */
        private String text;
        /**
         * 图片地址,可以通过上传媒体文件接口获取
         */
        private String picUrl;
        /**
         * 消息点击链接地址,当发送消息为小程序时支持小程序跳转链接.消息链接跳转,请参考消息链接说明.
         */
        private String messageUrl;

        public LinkBody(String title) {
            this.title = title;
        }

        public LinkBody text(String text) {
            this.text = text;
            return this;
        }

        public LinkBody picUrl(String picUrl) {
            this.picUrl = picUrl;
            return this;
        }

        public LinkBody messageUrl(String messageUrl) {
            this.messageUrl = messageUrl;
            return this;
        }

        @Override
        public String getMessageType() {
            return "";
        }
    }

    /**
     * 消息体：卡片消息
     */
    @Getter
    @Setter
    @SuppressWarnings({"squid:S00116", "squid:S1948"})
    public static class ActionCardBody extends MessageBody implements Serializable {

        private static final long serialVersionUID = 8568027947229962361L;

        /**
         * 首屏会话透出的展示内容
         */
        private String title;
        /**
         * 消息内容,支持markdown,语法参考标准markdown语法.建议1000个字符以内
         */
        private String markdown = "markdown";
        /**
         * 使用整体跳转ActionCard样式时的标题.必须与single_url同时设置,最长20个字符
         */
        private String single_title;
        /**
         * 消息点击链接地址,当发送消息为小程序时支持小程序跳转链接,最长500个字符.消息链接跳转,请参考消息链接说明
         */
        private String single_url;
        /**
         * 使用独立跳转ActionCard样式时的按钮排列方式：0:竖直排列,1:横向排列必须与btn_json_list同时设置
         */
        private String btn_orientation;
        /**
         * 使用独立跳转ActionCard样式时的按钮列表:必须与btn_orientation同时设置,且长度不超过1000字符
         */
        private List<BtnJson> btn_json_list;

        @Override
        public String getMessageType() {
            return "";
        }

        @Getter
        @Setter
        @SuppressWarnings("squid:S00116")
        public static class BtnJson implements Serializable {
            private String title;
            private String action_url;
        }
    }

}