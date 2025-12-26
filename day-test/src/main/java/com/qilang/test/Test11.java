package com.qilang.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test11 {

    public static void main(String[] args) {


        /*String appId = "b542c700_8cd9_489d_8cb1_71c43702";

        String appKey = "79babdf6b6ee43bd97ce833322b12045";

        String param = "{size:10,param:{\"parent_id\":\"\",\"id\":\"\"},\"page\":1}";

        HttpResponse response = HttpRequest.get("http://api.qichacha.com/BelongGroup/GetInfo")
                .header("Token", token)
                .header("Timespan", String.valueOf(time))
                .form(params).execute();
        System.out.println(response.body());*/


        //System.out.println(System.currentTimeMillis());

       /* List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(JSON.toJSONString(list));
        list.clear();
        list.add("5");
        list.add("6");
        list.add("7");
        System.out.println(JSON.toJSONString(list));*/
        /*List<String> categoriesSortCn = Arrays.asList("涉制裁", "涉制裁关联", "涉执法","涉监管","特殊关注","负面舆情及其他","国企或政要");
        List<String> sortedCategories = Arrays.asList("你好","涉制裁关联","涉监管","涉制裁");
        // 使用 Comparator 排序 sortedCategories
        sortedCategories.sort((a, b) -> {
            // 获取元素 a 和 b 在 categoriesSortCn 中的位置
            int indexA = categoriesSortCn.indexOf(a);
            int indexB = categoriesSortCn.indexOf(b);
            // 如果 a 不在 categoriesSortCn 中，将其排到最后
            if (indexA == -1 && indexB == -1) {
                return 0; // 两者都不在列表中，顺序不变
            } else if (indexA == -1) {
                return 1; // a 不在列表中，排到后面
            } else if (indexB == -1) {
                return -1; // b 不在列表中，排到后面
            }

            // 否则，按标准顺序排序
            return Integer.compare(indexA, indexB);
        });
        System.out.println(sortedCategories);*/



       /* String suffix = FilenameUtils.getExtension("新增字段sql.txt");
        System.out.println(suffix);
        System.out.println(FileUtil.getSuffix("新增字段sql.txt"));*/

        System.out.println(verifyPassword("Aa123456","$2a$12$3OUV2bzbn77tiAYX/wWqsO3Kpna0H1VnkGd3tVmHbMcI1s5EtKlFy"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$QAzetawET7D7Qyt6/.341.NWj3hBeWFL38CBy9mstG2mq0WBrCuBC"));
        System.out.println(verifyPassword("Aa123456","$2a$12$7JTcheAwxIcCwO.ZmxPtFOjHzxl5zT0HCEDwuAYXHrTg8714xOuwW"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$AW2etJpXP3dq.sox.pu99.soDgceJZgT7mMxecV0HMOKBD8nNpqU2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$rXtTe35cPwc8jVfurvw/SusYD/.3Jyhmb59ro5AQyX3qWj.n.Mkp."));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.0S9./S6S/94cBVxIR/F9ObG6xs6srTOXWgltmsg.5Pa5Q5sEhP2y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$o1Ynkz9xRKsCUyMpGF82y.r9.d2E6Z31wGESGiujW1zCcMz6MmTKO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$wqNVkHDnk/FqlOm1xGH3r.Ibod0IWSsr2vkn33MelRJpqSNFtBFwm"));
        System.out.println(verifyPassword("Aa123456","$2a$12$g.qhzLaffKxMQwn4jWM2auE.ISzoR3mt73OgqkFKg3n3HrriJ7N4y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$fAYUBEsVp7TXZyvOdkO3y.XrxxKAMMxpd0lrHnfv.185FjwALczSu"));
        System.out.println(verifyPassword("Aa123456","$2a$12$BLvMYEQvDBpA30gpTnoPVO2mNgmL8.RauInmNFONMQ22Kht8vgRSO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$ISf7zJmwZNfRM9.cL58UROzIgWYIwx6rdu6P1lyk6MGkxvgOjXMH."));
        System.out.println(verifyPassword("Aa123456","$2a$12$L3KVad3G.AEcmzeZ1Q8hWeg15O1eZXBHcym5vxwDzGZV6cBYcNRoS"));
        System.out.println(verifyPassword("Aa123456","$2a$12$fJE2lkTUMBu/ymiCXEreJOADbMVqNWguEQAvjEXMfu5ldPAaTgWka"));
        System.out.println(verifyPassword("Aa123456","$2a$12$3te907g/VD/ivZSL1LIYUe4lpoz3Rq66fW19YQGlptVkBUPkisDM."));
        System.out.println(verifyPassword("Aa123456","$2a$12$ELChqdvncoCF2qnkAOow6eoH3ChWRplHqh6.khGdlN0gXfSD6IMAe"));
        System.out.println(verifyPassword("Aa123456","$2a$12$AwlnySxliACA2FTXURguQuOb5wS5nAos8Xwkvi.6gIJVJJNlDB8sq"));
        System.out.println(verifyPassword("Aa123456","$2a$12$Yo0R3NzKxgcIgVfWCDuIJuoQsliGlRJvyJIgc6ApDzt5I8HX5GGAm"));
        System.out.println(verifyPassword("Aa123456","$2a$12$V96.CcX4K/q29.RACKtz/u0Pf3a5ofxzwpOwXlltykdpYZZE2MCU."));
        System.out.println(verifyPassword("Aa123456","$2a$12$PHFwe8sHpkTWYPyfnZWnceOdrZqLZmZ5I1PFurAFnXJ.dvEvCKQgi"));
        System.out.println(verifyPassword("Aa123456","$2a$12$kjT9CIr2e8bhCFWhmkGOV.xP3/gAtc24Ek4Wgk0QpArJzCIzqej/i"));
        System.out.println(verifyPassword("Aa123456","$2a$12$DbsnAVF.qmemtXu.ypZMRORzwnZI7yfFo5aSci44AZZBRD/XbVcNa"));
        System.out.println(verifyPassword("Aa123456","$2a$12$n2nHi.zJgXMOHjgIWt9wIuOYaqMDBhcdpLLlQyt1mi35XUKkmdnnC"));
        System.out.println(verifyPassword("Aa123456","$2a$12$UaFKxexPeFCb5MLQ0vcSMOzOmYqQAIaDnRZ.50UblM1JNpiaBfer2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$x49FZOFtCYkGcZfNcIhtJOrZnApS7umMjdHiYSHvytTYqhPq3HYkW"));
        System.out.println(verifyPassword("Aa123456","$2a$12$yubugnfp.9NN6x4m5nioK.zL/FS2imuw.MXX7Qyb1Q/gDFb38b/EO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$bI6p0VnYdmKr6bhJ68.Tw.0TRW/k6im6OqH9JvZN39NUK44vGXJrK"));
        System.out.println(verifyPassword("Aa123456","$2a$12$5v6ANLe6wlTieFWMh7zOpuOHfbUaixd3kdcoS60M/T/E0WfXVM4FC"));
        System.out.println(verifyPassword("Aa123456","$2a$12$JgO21aXrQoIw5LwoUU54vOnbcWYWj8HFIHIrb5GLPmBB3btvbH572"));
        System.out.println(verifyPassword("Aa123456","$2a$12$J3MKA08aP1WU4GOPjy.sq.3a/kN9JjJA0fuhafzfUYiViKHyQu1Kq"));
        System.out.println(verifyPassword("Aa123456","$2a$12$Kx6gVpdjW8mdDqNGs0wH8Oi5KZg5uJDj3lo0xlR9C1PAOCEH4Sqay"));
        System.out.println(verifyPassword("Aa123456","$2a$12$JJqbN3jZOtMTbo7IdYdUi.GuMFzafLvn6v/Us2Z1D55jZ4N9qUMDC"));
        System.out.println(verifyPassword("Aa123456","$2a$12$Scn4oVfvBE8WvYGw1OeSVuwRzNJRCDcpATHbfOJxAZMs91G4ioojG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$OdrPcfxGIQAcGdAjZYh/4uHG0xsvdewDpBli0i5CdxBkbMQy5UPq6"));
        System.out.println(verifyPassword("Aa123456","$2a$12$Tj8CPuF0IOm69ATjIl.CSe3qCLcsbEt5RiD60BTG2OcuEB1w3N4JO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$X2nMCHDwen2nwrFsL6UADeJELzahvq3O6Z6cnK6nzm/PfKNqKNav2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$xZd5V7uR38b.xTzXDWI7puMFkGIlhs5lAHTO9DEqd7Jx8v8c3kmCu"));
        System.out.println(verifyPassword("Aa123456","$2a$12$KLHJVV7yMtKU.RRl0ExJdOr1PbuzrQx8MzPTVgkTZRyKzyqKTrWFq"));
        System.out.println(verifyPassword("Aa123456","$2a$12$Lhbg1xfAOTh1LnQLA1hlNu0hg00jMNrV1H.i8QQMmMOngAlcehTza"));
        System.out.println(verifyPassword("Aa123456","$2a$12$1CAAX9cEZFIq72hgs0i7OutXotJwGSzeEj6wlpifWAbMeYyiZXm4K"));
        System.out.println(verifyPassword("Aa123456","$2a$12$Uwuwoed.eecAUDaZp6maVe4Pe2ZIqRxTWL/3vtOOgX5zpSC7d7GPy"));
        System.out.println(verifyPassword("Aa123456","$2a$12$lcx9HREb95YA4pTJa9L7Tu1KE/5Ynw.QfMmmpUfxBUJ8XGErOsYXa"));
        System.out.println(verifyPassword("Aa123456","$2a$12$lnGQqOMc//0UBad1H9iyG.8.t4xZARnVCxZciRfPZuS6fTs9M/GcG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$cgQy6aQXDr5BxIV3054gOeMvOr5Lc1nsPlEtAOi4d2wg0iyf7UuRG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$nRhSMnKbXhd0bVv8DMgi6OQYdseQxUAG66b.WlRMbd1ej6wfI49NO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$NtnKi7U/AV56e6juRJ3oWOL9INy6y6H7okxoanWp4XiT4k0YO4SvO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$EN.raVsyT.Pyl/y6AVR.0eM1C1Xq/PLLnuIq2vTLhlHPrlGRK7.fm"));
        System.out.println(verifyPassword("Aa123456","$2a$12$xaczw5e3FMfICW/q1qVIFuahDg6RYAMVGoAmb4tKVnDDuJwg/Hogu"));
        System.out.println(verifyPassword("Aa123456","$2a$12$HuNW.Auik0qPYk.VkWHgq./FzyZM.YWuPOpnY7x/uznbR.70p3u8i"));
        System.out.println(verifyPassword("Aa123456","$2a$12$coj7Fx2DyM/fJsZcH6IKVOz3JRycYpaqWYM5xKek4qJPLy/3mnfZi"));
        System.out.println(verifyPassword("Aa123456","$2a$12$useNlotf0lcovSXxJneeu.h.48HrzeCakEi7CbX9RmxUuJB8HWH9e"));
        System.out.println(verifyPassword("Aa123456","$2a$12$qsU/jWlIbSHoGHTsI7OAAO29AemTUYHh7Tc5ve.hzrRavJrt4dCGq"));
        System.out.println(verifyPassword("Aa123456","$2a$12$MndOAWClXKquwc.rT6rjG.QCwO6.SCMET6YuAbWl3bQc9nd3ywcQS"));
        System.out.println(verifyPassword("Aa123456","$2a$12$HoySBoVrlmOg5yphwNNJhev1NT4Exj4fBohstHdSMAo86MxjGm7im"));
        System.out.println(verifyPassword("Aa123456","$2a$12$sjB7FG48rtSRv5YdnOMTBeTDZKxvkCfVe.NWJL3gx/sQVevyAO.IS"));
        System.out.println(verifyPassword("Aa123456","$2a$12$W5ELip/xtnnopvIvWSkO4e4irER/5HhSG8pwQABNDHq03IMLQEF9O"));
        System.out.println(verifyPassword("Aa123456","$2a$12$obGbndyX7RwaEYaa2d1eou3cYNIbwMa668OcZrrgq1qYcv/XyV6.i"));
        System.out.println(verifyPassword("Aa123456","$2a$12$2lSUQqu7QcEEeNR.So7hwOdSvsol.40vZGOBWitIY0YbVG0xxxv3m"));
        System.out.println(verifyPassword("Aa123456","$2a$12$DiswgAtvGKx/V8UNi6pQaO5kBHWBCZlWXsDFixvrsuc6kOmkwJH3i"));
        System.out.println(verifyPassword("Aa123456","$2a$12$b5ZSx5BmWiRn6blFtdqUHePwobOgIF3pCCDycZ1tN0kpu2UnvMCCS"));
        System.out.println(verifyPassword("Aa123456","$2a$12$hlFdNGz5hPrFabriRhweseG94krZqMTrdFkvbh1/tG1k6OykqA.Ly"));
        System.out.println(verifyPassword("Aa123456","$2a$12$e92Cx8pyaJ4T9nUDS5kjIO/RRr1/rHV031bptCWBBRm5icDyZO2qW"));
        System.out.println(verifyPassword("Aa123456","$2a$12$GPMzP9dWy71SJrUGrNkcUux7mvscY3QDGfpJGA.bUfAMz6OlLRvv."));
        System.out.println(verifyPassword("Aa123456","$2a$12$GRf1IBi/0MU8ATolrtkDL.9jmw/.jMbXMNkPIRAzQ38OuLscqQdc."));
        System.out.println(verifyPassword("Aa123456","$2a$12$sg6WRk4KMl5mlQdVLnlnYONN9vHDUTlPObhyyqS2L1cZLS7lV9ko."));
        System.out.println(verifyPassword("Aa123456","$2a$12$IEUZEaxht/NK4hSwb8yyrO/UxX.gpMP84Hm595Z/UjurzCfhL08jG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$aMuCaGoWYH4AdRyMpt6O7eigHzEkE5tIas/6Ee4Q3aHZ4cSh6KWXO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$yArvy6chOpRu0XuhlvJSi.c6siqAXfs9pscUSZG9U3/x1jfNX1ii2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$9cbWJ.zkqChnyDQPzbTzOesQUdMRyybZJawaK9NkxrNv1rIvU8u.W"));
        System.out.println(verifyPassword("Aa123456","$2a$12$EvwDTOM2TYyh6OO8RXctU.MFKxzJalP/d6P3ox0WDZNrXCDIbA3eC"));
        System.out.println(verifyPassword("Aa123456","$2a$12$gG3mzW8/woLyMIF.eyuZhu16AEHLFKLawa6K7hB14IUuCm9hHY2o6"));
        System.out.println(verifyPassword("Aa123456","$2a$12$Qaa.W6dDZLmnxve8MqsUmew4fl8XOWCujIYYLDKSvL/aAiOXGK.0W"));
        System.out.println(verifyPassword("Aa123456","$2a$12$nZoxm8irBSIDOt7cFuiTwe2lt2byW2HEI/rLIotgdjhgeB4qDLvxG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.NWF8FSe1YQYJ.7HiKUiSOIRbA5DDFyLczjP4OBCtUnxE/n30/4se"));
        System.out.println(verifyPassword("Aa123456","$2a$12$eXU9K8gze97Qux17rJ/iUuy0W2O2Ol7en7Y1GmVl0JNkei2hkRWxm"));
        System.out.println(verifyPassword("Aa123456","$2a$12$qK3SvUTRNbfDMfatuDiSVuPTqaebZJwhZPCwj29XmqdgkqaD301ci"));
        System.out.println(verifyPassword("Aa123456","$2a$12$jTsfV0pjAltKw0FCjoxu2.Ex4f16eNQpR7o3MTiQMLQTUV8eubNRK"));
        System.out.println(verifyPassword("Aa123456","$2a$12$zN5uvigPOE7S7rIPoP0i4etcswwAq5B1Im7VBsbUWDbGHFyrX8zuW"));
        System.out.println(verifyPassword("Aa123456","$2a$12$N26Z2kAk92zhUZ9Or/NYfOLBFBrhtceiPjCp60yogSDSaLhSWVxx2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$4TNsqbNKdux.o5MmOUWhIOc0D5uPCGUsvcts.tzcvaM2lmWGSAaN."));
        System.out.println(verifyPassword("Aa123456","$2a$12$31ibrWGPbbrrgjUkYW3q9us15XkWOoeGqjR3xFGOLSq93vPJ1XisG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$QRVgomzYVhEj5EPdGtM49e05K7nFO10R8wAnHbA4Ou0iJvF5/oBue"));
        System.out.println(verifyPassword("Aa123456","$2a$12$8sOE6o9aoZjwO4RkKeeQWO2en3IFjBrTuvO1LCnzaTjyUoAg9Er/u"));
        System.out.println(verifyPassword("Aa123456","$2a$12$5Q.HhEDqNk5oq7PQgJltgu4Tl9E2qsX4f58uLdGUb7GOz7O1WN37q"));
        System.out.println(verifyPassword("Aa123456","$2a$12$iINQkGxFeDM40KeOzOj7d.zlvb6J5LAPnA9KiwVw34zwbQQBAJkd6"));
        System.out.println(verifyPassword("Aa123456","$2a$12$QJRA5QzwnPO8HAVIyg29ROe8JiYz/RoUyPXs23CdIsDXIeKvQb5f2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$JYjYZiGX/31MFMkA2Cp6nuwMZEAk0WJpiAPa5Ce8SsADzeG3LU1rG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$jdNkNRKTJEGNfKEe7igVf.lGymYQfwKcCnhv9IdHcD6wquGpM4As."));
        System.out.println(verifyPassword("Aa123456","$2a$12$OY8JgcJPQHp3tJIMh8LoHu0GE.NSCTcamjUbgr2qirIQoAgLdc4cy"));
        System.out.println(verifyPassword("Aa123456","$2a$12$gXK1YRvsIAOvwtMwc5AXRupK0KPCHD7Ra9i0jqRWJR3Z7J3nSEybW"));
        System.out.println(verifyPassword("Aa123456","$2a$12$KlH.0eBxCWFb3iqM4E9go.8z9SQpU2dugPrBfAhgspJ0/V5H5zNj2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$vK19oCUV8EG7Nrxer33Yn.DbKv6Ra6Tx60RCTmR6wJe57rOnKaFGa"));
        System.out.println(verifyPassword("Aa123456","$2a$12$MSKm635TSrxohuKuRZoguuRawyNsExYLQX3gq7FE36O7gMTCkrhm2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$dGeEqyrbwsxbmLWNG0x27O2CEDecU9OMeId7HucZJfIeTuEaS2WwW"));
        System.out.println(verifyPassword("Aa123456","$2a$12$E8wsmxtcsYom6u7sXzSj4Os2Buxei4cOy/cW2.rvJrUJ9X3OaBZha"));
        System.out.println(verifyPassword("Aa123456","$2a$12$r7uV/5O9Wh4PcE9JUptguetLczyRYTyneN1E2aZiLi7f9NbDBquJ."));
        System.out.println(verifyPassword("Aa123456","$2a$12$CqVcsp/C6hwMp7P1gsPXCuVFg8lZw7S6i1u6AyuyZ/MqF2VRbHx.K"));
        System.out.println(verifyPassword("Aa123456","$2a$12$iFfyNbRcEy9hI1V9zh9Tne3iLwHmp82rCw/yq.AJyMrzdttHxnvZi"));
        System.out.println(verifyPassword("Aa123456","$2a$12$C0oLL/W9zbgR4u7p2GzdFOZaSpjWFNbGn.u1/S14jW/1r1JuYxHJK"));
        System.out.println(verifyPassword("Aa123456","$2a$12$23x3KrTZz5iXbB2FE6GuPuAMOLuZvbptouaPtwwj83xkjwz/Uz2ku"));
        System.out.println(verifyPassword("Aa123456","$2a$12$FxM76fnDNJl0kS.6OhtpLeflhwRONZhXg4z.Q.yOkOGcAsicAVqOC"));
        System.out.println(verifyPassword("Aa123456","$2a$12$MQqRgQj4CTpFudCOuBpQZufB2GPPjAqO7KuvKEhfhMf/JX.MKl5KG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$hT.5iw3btX35pMJK/hN89OW6Y/9gDTfK6uBVeaSGcOC6MFOjb5iIa"));
        System.out.println(verifyPassword("Aa123456","$2a$12$.jVVIHqL3ttbIemzKVvMF.r2/iUsaiDmkngtFI/DB.CEPHTD7Ca4S"));
        System.out.println(verifyPassword("Aa123456","$2a$12$vE2nv4Za5TRVhmQOlowN0OC7twlC1oPov30qncp/iGBjLv3JdzBIy"));
        System.out.println(verifyPassword("Aa123456","$2a$12$BMw0G1wyGS.VxTQaHMPzx.dOLpE.06GB.AnwyVa5.5/3NHI.WE8dq"));
        System.out.println(verifyPassword("Aa123456","$2a$12$9yNFDr2QPMEe1DttJJ6pKuUVOrfY9iOqeh0t79nhdSJGecqLJi6HW"));
        System.out.println(verifyPassword("Aa123456","$2a$12$Zi28O8iOMh.BL/Xd3oaZwus5UTOGtC4/fv7DuJhuyF3LgYxxYI9Cy"));
        System.out.println(verifyPassword("Aa123456","$2a$12$bd5wJy0/8CcS1uOztE00setr0XSt4O0hsH0zuZvoqb3GYz7si.nVm"));
        System.out.println(verifyPassword("Aa123456","$2a$12$wxHqW4pv6Bv1Nkn/tx4n..qlNgaGK2rGhcdlkti8ji.DuGThq0fly"));
        System.out.println(verifyPassword("Aa123456","$2a$12$PnQokRZ/ZA0BH8TW3GFUpef62kZjl05PT9chyP03HL4c7BtaQ2h0O"));
        System.out.println(verifyPassword("Aa123456","$2a$12$1ZFowrbss25BcmxnDiTlrOowFJf0hcJG2HG2/apBCnK3KZDSYBmJ2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$IqA7b9X.Qjomimv.bKLDjegW5/QEjTL9Xj662gc4z/ie7jSlqL45m"));
        System.out.println(verifyPassword("Aa123456","$2a$12$74TeYb7L6vLOcgo1KfLcsOxiZAbo38eSJh0H8CHbXH0H7xXmo8EO."));
        System.out.println(verifyPassword("Aa123456","$2a$12$cUb0jFELT4KJ6iKBMPwKheHBsZvmfrzqE7vjS4dXaU4LqkFT563j2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$f3b5ygAFo8ZM8824ODs9MuY98zqeu5mbYWo3huAvewjSK2GkJ5m5y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$yxHpooDOrAQzSAsoIZ5df.Tr1naIvXcJtTeDZXMWdq72cIKMVEI3y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$WIo12kLUa2fZ1Fp8BKlVvOtFLJhEmJQ0uQ/ZlZZ6OKmkY0bH4/dQ."));
        System.out.println(verifyPassword("Aa123456","$2a$12$6Jzy7p5aoL0k1St6IplFbOXs.WTfSfnzBG/xxMVyiuCwUFohZ8H3O"));
        System.out.println(verifyPassword("Aa123456","$2a$12$/4YicJ9VI4KemusKmSt/N..hgU/2d6HJqhmukpXDxv6XWvL2EUeji"));
        System.out.println(verifyPassword("Aa123456","$2a$12$./pLdnJBjgAxC4H2eJ7zf.BK5MutkUYPeW/0QhQDflAhZjfHtyWKu"));
        System.out.println(verifyPassword("Aa123456","$2a$12$iaJ.Ph7X9evxd1CxdbEXS.cQWi5RfQ7MtMgWg/oHJC3yGFZ9o6jV2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$UU0UF4Ul0WkNLBxdIIYkTe.x87DeXH8Ez5RDY9dx4SyPWjRCj933a"));
        System.out.println(verifyPassword("Aa123456","$2a$12$UO.ADhrs7AaL9FdLfDZdHOo3YrR4xTzl1tvnTCSEsDYsGKivs.132"));
        System.out.println(verifyPassword("Aa123456","$2a$12$thDR/uowGllwJGz9d4haeuJA/WrfSaOfew0apnGT1Tbqa6RAhRKaO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$aR3ZsW3PYhuvY9.X3oh7/.GemEixC40XxuMRV8d1zci78EC5kSU5y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$BO5e1PS9YajZPmfDEW5Bb.Rs8kkGf9/BP/2qjoeif0L8slIj.S4z."));
        System.out.println(verifyPassword("Aa123456","$2a$12$Cmr2D7ugJKe9pAn8tj/.zeO.eRY5dOR22Qe21Vz8u4CtzcGzxZF7C"));
        System.out.println(verifyPassword("Aa123456","$2a$12$OnUfKtcP8taDSve/PtnLy.VTk/v0CuOcPhwtiVB9VToB.fHTTlGX2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$lTE4zBpdWJLtQF2DWBNUfuRS/v39Hmk7Fb1TuLA.DV72/eipXhXLu"));
        System.out.println(verifyPassword("Aa123456","$2a$12$XZ9/AF.q5.HpYz/ZUscPdOA2RGcz7WyTL2yKtG78WQ2Qtuj/sCd.W"));
        System.out.println(verifyPassword("Aa123456","$2a$12$7FGY8PGp18O8WUxBmjEk4uItczneSDHxvRwnZ4jAjf9afzi4EpMbK"));
        System.out.println(verifyPassword("Aa123456","$2a$12$xYSi32ZweQqMUyN8LTVnV.jdI5CSeu1FR8EA90IG7r5Ixxd7uEc8K"));
        System.out.println(verifyPassword("Aa123456","$2a$12$I406mt/ggoq8fEa6WejUVOWZkl4WzdW/nuAW8zgaUFlq4vHgFtZW6"));
        System.out.println(verifyPassword("Aa123456","$2a$12$KhsPDSqLdBpmJ4bLcqS5heeiT/slcI9yUxN5wGkocZ8r06f7qCY/G"));
        System.out.println(verifyPassword("Aa123456","$2a$12$oPgET8CwBwMqXihPqqQPbeJ5A5QjVOydz6npoAhxs7AJlOtHw4Eyy"));
        System.out.println(verifyPassword("Aa123456","$2a$12$IgovciCqh1G7qQvPDRIyee9fzZpWVXY4Yfs3qFgPzdU7FyGUeNXj6"));
        System.out.println(verifyPassword("Aa123456","$2a$12$yrdXrGjD/uizeBOxPpa6n.QXS4cMs5yvCcmjodZIUpqU2dPLdW/o6"));
        System.out.println(verifyPassword("Aa123456","$2a$12$kYxd7qf/la.Rs3OLO.UZSuaWzVov6tc3kkX2PMowul14WD7Xaqg16"));
        System.out.println(verifyPassword("Aa123456","$2a$12$1dgtLiIWP7n29nHmW/9sI.zXe.bkSz6AqdPSSODc5sVEr8YBiZGgy"));
        System.out.println(verifyPassword("Aa123456","$2a$12$XPRR9n3Zod9MRaPgXatL4OzkaqrdyigFYild1x3/AVzDCXHCSOGGK"));
        System.out.println(verifyPassword("Aa123456","$2a$12$6tnEkV/ayMMpt4fJfNWtKOw8gUfvSbw/e4kH7jeZB1ejGMgZYR7sC"));
        System.out.println(verifyPassword("Aa123456","$2a$12$NMKBbJmky.6IQ5Y4KGi8Yu0ytcqANs/7a94rnSisNJ/FqDYS73guS"));
        System.out.println(verifyPassword("Aa123456","$2a$12$9omOUbCfdTsRuMTy8GpgkeIdB9UltvDiRyjsZOW.jfJLt.VC8j7qm"));
        System.out.println(verifyPassword("Aa123456","$2a$12$xZp7siW8UWDGf6tAudWG6ORyNNcYt42zV2S6aGDm8IpwQStAQ4Up2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$GhYOLTBxdA4HMR7Yf2QGNeFseuV74iV7jmmZ9k6jsmpanHza1gjTm"));
        System.out.println(verifyPassword("Aa123456","$2a$12$G/G/z1nqYPUxQ7PnKjp24OsYNVyTphQcdbjI/eL0sZFkonGqg9GBG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$HQcyBjuI7mzVbsqIXpFWpekAJcPuMIXT3biggFAiWii0PHrd5Gal2"));
        System.out.println(verifyPassword("Aa123456","$2a$12$af5dr7EebaU8Rd/jMvrRe.VjOVtmQ4qXAqoxtramcTagoXNHVmRfa"));
        System.out.println(verifyPassword("Aa123456","$2a$12$Qk45lks0YwaDyU4PDaCdJ..SXTaEtCarH0CqjzdFIxR.8stQIUioG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$yT8./FBeTWWYuKc174Nbqe4yFqMvynvpUJQ0qASS5IFyLLMWheILq"));
        System.out.println(verifyPassword("Aa123456","$2a$12$MjiTbK8jvlC7Yp52HuVTo.4ud72KRY9o.yA3Vs1uKK0vgEtDt.0sW"));
        System.out.println(verifyPassword("Aa123456","$2a$12$5KkpEEZNrAeV8HhCwdfaLOakwSup3s4bBXKhqD5tM3ij0rXgeNqvi"));
        System.out.println(verifyPassword("Aa123456","$2a$12$oBMWzrvr3KX39Tzfo/0m0eCSjgN9tGyjXRuN.isJ.wnei1RtXe3wy"));
        System.out.println(verifyPassword("Aa123456","$2a$12$a.7T/aQxPV91KXBMmRhx8OJPLjcHGDdhRPWK57nUJzR0ELw21hTpK"));
        System.out.println(verifyPassword("Aa123456","$2a$12$v99fmbd0g.3mfPqwYXcY6.5H2VTSgcv5ApsvQaVM8fIP7yfO6U726"));
        System.out.println(verifyPassword("Aa123456","$2a$12$aNcPdbCE0LGWQSwbFXk5suHOO0/JGD8KQXjOoIcUB0CAWQhWRWYLu"));
        System.out.println(verifyPassword("Aa123456","$2a$12$x0AMZJaMn8zysGu9N7XKqO36dQOEhqLJHGyVpbnbUZC8E/j9BB1tW"));
        System.out.println(verifyPassword("Aa123456","$2a$12$gl3kQGwuBS/RVfRju2W/f.rg9hHdB9AKbdYt.lYkWWu2GQCO3aT1a"));
        System.out.println(verifyPassword("Aa123456","$2a$12$ZgqnoHNwB70YOOgEq4rRNufhatNqYF8LphkkKhAgzih6lJst6gXoO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$LIwELNBuWcrczShN.IlM4Ou0g2OBXGr6ECYuhx93zuPjucLZloNne"));
        System.out.println(verifyPassword("Aa123456","$2a$12$klvOzHcF3BKkawEV6Dhs7uNcClrD7R7e/ded8bPHAwAGBVYfHYn6y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$clRU3x8KIakxz6L2q4dbJ.GDIddelAk5ihvAhySq3/8Yp8R49ki66"));
        System.out.println(verifyPassword("Aa123456","$2a$12$T/xmSngK3LGzhXjlXOc.HOZufFFRkHrWDxKKIWL4.6pyl7kYgJuwS"));
        System.out.println(verifyPassword("Aa123456","$2a$12$ujWXn5g3cYKqvVVMdDEQOuvP1F7QCq2N1FeyX.kHbdpFDh0Xfch/y"));
        System.out.println(verifyPassword("Aa123456","$2a$12$W.4TYJ4keaQk3EjFuGeo6e5NVSbcxc9LMtXKeWW5vie.yQN/qQrHq"));
        System.out.println(verifyPassword("Aa123456","$2a$12$G2PBbvyuBTDJtL7jJMUh8u4yOsNf5ahB3lomv6Q0iKVlzfeH0yu6i"));
        System.out.println(verifyPassword("Aa123456","$2a$12$0BzyXtoHtsxA3yT3E3YoR.dq8GOk9yHgotxJ1N0T6rrTxf3TvIC7W"));
        System.out.println(verifyPassword("Aa123456","$2a$12$CWxls8cFP1QLnmcv6wsyvOgf0bzUD4fjD7VSj3Y5A626k2VdDLqV."));
        System.out.println(verifyPassword("Aa123456","$2a$12$N8VrC0MsTy0yHKVMs6KGeOs8FAauSEF.FCmmhSUc8VD2uSNRMP0Eq"));
        System.out.println(verifyPassword("Aa123456","$2a$12$8hF3dASFliObnxFk9tIZ.eEwfe6wqDx1m07fGxY5NLR5UZ1liYzsC"));
        System.out.println(verifyPassword("Aa123456","$2a$12$1xr6FkR.uZOVBFtqymETkOiMgw8EYoVfU2mEV8MszuAiXy.1dtXqO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$eNNVJXziI44BjQ/NR7DWsOkj8qUwfXWQKUlFvs0BWYKhHV0PlhbZG"));
        System.out.println(verifyPassword("Aa123456","$2a$12$th8PJwypz7gDP9xsWrcm.O/b96iTsfz.1u2PWqrs1HdXD8XcmUcUi"));
        System.out.println(verifyPassword("Aa123456","$2a$12$YhUf3JyROcg6pigPMnhEEuYF3faayGPd/9iZg3hkB/CTfkCi1DDxO"));
        System.out.println(verifyPassword("Aa123456","$2a$12$rAaoO.qeyHDRYkabBnWYxuO8qaT7QCpDEQlBIfGDSB7Zei3h9u6iO"));



    }


    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        if (plainPassword == null || hashedPassword == null || !hashedPassword.startsWith("$2a$")) {
            return false;
        }
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
