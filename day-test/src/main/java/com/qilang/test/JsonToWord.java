package com.qilang.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JsonToWord {


    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入json文件路径：");
            //读取字符串型输入
            String jsonFile = sc.nextLine();
            File file = new File(jsonFile);
            if (!file.exists()) {
                System.out.println("找不到文件");
                System.out.println("程序结束！");
            }
            System.out.println(jsonFile);
            String wordFile = jsonFile.substring(0,jsonFile.lastIndexOf("\\") + 1);
            if (!file.exists()) {
                file.mkdir();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            String res = read(fileInputStream);
            JSONObject jsonObject = JSON.parseObject(res);
            XWPFDocument word = createWordFile(jsonObject);
            String fileUrl = wordFile + System.currentTimeMillis() + "word.docx";
            saveDocument(word,fileUrl);
            System.out.println("word导出完成：" + fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置文档标题
     * @param jsonObject
     * @return
     */
    private static XWPFDocument createWordFile(JSONObject jsonObject) {
        //解析json，将json中的数据放到word中
        //获取api文档名称
        JSONObject info = (JSONObject) jsonObject.get("info");
        String title = (String)info.get("name");
        XWPFDocument document = new XWPFDocument();

        //设置标题
        createTitleParagraph(document,title);

        JSONArray items = (JSONArray)jsonObject.get("item");
        for(Object itemObj:items){
            JSONObject item = (JSONObject)itemObj;
            //设置接口文件表格内容
            createTable(item,document);
        }


        return  document;

    }

    /**
     * 生成接口表格
     * @param item
     * @param document
     */
    private static void createTable(JSONObject item, XWPFDocument document) {

        //创建1*6的表格
        int row = 0;
        //接口名
        XWPFTable table = document.createTable(1, 6);
        //设置表格宽度固定，但是有过长的字段时会失效
        CTTblPr ctTblPr = table.getCTTbl().addNewTblPr();
        CTTblLayoutType ctTblLayoutType = ctTblPr.isSetTblLayout()?ctTblPr.getTblLayout():ctTblPr.addNewTblLayout();
        ctTblLayoutType.setType(STTblLayoutType.FIXED);
        //设置表格样式
        //table.setWidth(7800);
        XWPFTableCell cell1 = table.getRow(row).getCell(0);
        //设置表格宽度
        cell1.setWidth("1300");
        cell1.addParagraph().createRun().setText("接口名称");
        XWPFTableCell cell2 = table.getRow(row).getCell(1);
        //合并2-6单元格
        mergeCellH(table,cell2,row,1,5);
        cell2.setWidth("6500");
        cell2.addParagraph().createRun().setText((String)item.get("name"));
        row++;
        //请求方法
        table.createRow();
        XWPFTableCell cell3 = table.getRow(row).getCell(0);
        cell3.setWidth("1300");
        cell3.addParagraph().createRun().setText("接口方法");
        XWPFTableCell cell4 = table.getRow(row).getCell(1);
        //合并2-6单元格
        mergeCellH(table,cell4,row,1,5);
        cell4.setWidth("6500");
        cell4.addParagraph().createRun().setText((String)((JSONObject)item.get("request")).get("method"));
        row++;
        //地址
        table.createRow();
        XWPFTableCell cell5 = table.getRow(row).getCell(0);
        cell5.setWidth("1300");
        cell5.addParagraph().createRun().setText("接口地址");
        XWPFTableCell cell6 = table.getRow(row).getCell(1);
        //合并2-6单元格
        mergeCellH(table,cell6,row,1,5);
        String url = (String) ((JSONObject) ((JSONObject) item.get("request")).get("url")).get("raw");
        if(url.contains("?")){
            url = url.substring(0, url.indexOf("?"));
        }
        cell6.setWidth("6500");
        cell6.addParagraph().createRun().setText(url);
        row++;
        //请求头
        //设置请求头标题
        int headStart = row;
        int headEnd = row;
        table.createRow();
        XWPFTableCell cell7 = table.getRow(row).getCell(0);
        cell7.setWidth("1300");
        XWPFTableCell cell8 = table.getRow(row).getCell(1);
        cell8.setWidth("1300");
        cell8.addParagraph().createRun().setText("参数名");
        XWPFTableCell cell9 = table.getRow(row).getCell(2);
        cell9.setWidth("1300");
        cell9.addParagraph().createRun().setText("类型");
        XWPFTableCell cell10 = table.getRow(row).getCell(3);
        mergeCellH(table,cell10,row,3,5);
        cell10.setWidth("3900");
        XWPFRun run = cell10.addParagraph().createRun();
        run.setText("举例");
        row++;
        //请求头参数
        JSONArray headers = (JSONArray)((JSONObject)item.get("request")).get("header");
        if(headers.size() == 0){
            //没有请求头参数给个空行
            table.createRow();
            XWPFTableCell cell11 = table.getRow(row).getCell(0);
            cell11.setWidth("1300");
            XWPFTableCell cell12 = table.getRow(row).getCell(1);
            cell12.setWidth("1300");
            XWPFTableCell cell13 = table.getRow(row).getCell(2);
            cell13.setWidth("1300");
            XWPFTableCell cell14 = table.getRow(row).getCell(3);
            mergeCellH(table,cell14,row,3,5);
            cell14.setWidth("3900");
            headEnd = row;
            row++;
        }else{
            //有数据循环添加到表格
            for(Object headerObj:headers){
                JSONObject header = (JSONObject)headerObj;
                table.createRow();
                setHeader(header,table,row);
                headEnd = row;
                row++;
            }
        }
        //合并请求头列
        mergeCellV(table,cell7,0,headStart,headEnd);
        cell7.addParagraph().createRun().setText("请求头");

        //入参
        //设置入参标题
        int paramStart = row;
        int paramEnd = row;
        table.createRow();
        XWPFTableCell cell15 = table.getRow(row).getCell(0);
        cell15.addParagraph().createRun().setText("");
        XWPFTableCell cell16 = table.getRow(row).getCell(1);
        cell16.setWidth("1300");
        cell16.addParagraph().createRun().setText("参数名");
        XWPFTableCell cell17 = table.getRow(row).getCell(2);
        cell17.setWidth("1300");
        cell17.addParagraph().createRun().setText("类型");
        XWPFTableCell cell18 = table.getRow(row).getCell(3);
        cell18.setWidth("1300");
        cell18.addParagraph().createRun().setText("必填");
        XWPFTableCell cell19 = table.getRow(row).getCell(4);
        cell19.setWidth("1300");
        cell19.addParagraph().createRun().setText("举例");
        XWPFTableCell cell20 = table.getRow(row).getCell(5);
        cell20.setWidth("1300");
        cell20.addParagraph().createRun().setText("描述");
        row++;
        //设置具体参数
        JSONArray querys = (JSONArray)((JSONObject)((JSONObject)item.get("request")).get("url")).get("query");
        if(querys != null && querys.size() != 0){
            //有数据循环添加到表格
            for(Object queryObj :querys){
                JSONObject query = (JSONObject) queryObj;
                table.createRow();
                setParam(query,table,row);
                paramEnd = row;
                row++;
            }
        }else{
            //为空或没有参数，设置一个空行
            table.createRow();
            setParamStytle(table,row);
            paramEnd = row;
            row++;
        }
        //合并参数列
        mergeCellV(table,cell15,0,paramStart,paramEnd);
        cell15.setWidth("1300");
        cell15.addParagraph().createRun().setText("请求参数");
        //返回值
        table.createRow();
        JSONArray responses = (JSONArray) item.get("response");
        if(responses != null && responses.size() > 0){
            XWPFTableCell cell21 = table.getRow(row).getCell(0);
            //设置表格宽度
            cell21.setWidth("1300");
            cell21.addParagraph().createRun().setText("返回值");
            XWPFTableCell cell22 = table.getRow(row).getCell(1);
            //合并2-6单元格
            mergeCellH(table,cell22,row,1,5);

            for(Object responseObj : responses){
                JSONObject response = (JSONObject)responseObj;
                cell22.addParagraph().createRun().setText((String)response.get("body"));
            }
            cell22.setWidth("6500");
            row++;
        }else{
            XWPFTableCell cell21 = table.getRow(row).getCell(0);
            //设置表格宽度
            cell21.setWidth("1300");
            cell21.addParagraph().createRun().setText("返回值");
            XWPFTableCell cell22 = table.getRow(row).getCell(1);
            //合并2-6单元格
            mergeCellH(table,cell22,row,1,5);
            cell22.setWidth("6500");
            row++;
        }
        //防止表格挨在一起影响阅读
        document.createParagraph();


    }

    /**
     * 设置接口参数
     * @param query
     * @param table
     * @param row
     */
    private static void setParam(JSONObject query, XWPFTable table, int row) {
        XWPFTableCell cell0 = table.getRow(row).getCell(0);
        cell0.setWidth("1300");
        XWPFTableCell cell1 = table.getRow(row).getCell(1);
        cell1.setWidth("1300");
        cell1.addParagraph().createRun().setText((String)query.get("key"));
        XWPFTableCell cell2 = table.getRow(row).getCell(2);
        cell2.setWidth("1300");
        XWPFTableCell cell3 = table.getRow(row).getCell(3);
        cell3.setWidth("1300");
        XWPFTableCell cell4 = table.getRow(row).getCell(4);
        cell4.setWidth("1300");
        cell4.addParagraph().createRun().setText((String)query.get("value"));
        XWPFTableCell cell5 = table.getRow(row).getCell(5);
        cell5.setWidth("1300");
        cell5.addParagraph().createRun().setText((String)query.get("description"));
    }

    private static void setParamStytle(XWPFTable table, int row) {
        XWPFTableCell cell0 = table.getRow(row).getCell(0);
        cell0.setWidth("1300");
        XWPFTableCell cell1 = table.getRow(row).getCell(1);
        cell1.setWidth("1300");
        XWPFTableCell cell2 = table.getRow(row).getCell(2);
        cell2.setWidth("1300");
        XWPFTableCell cell3 = table.getRow(row).getCell(3);
        cell3.setWidth("1300");
        XWPFTableCell cell4 = table.getRow(row).getCell(4);
        cell4.setWidth("1300");
        XWPFTableCell cell5 = table.getRow(row).getCell(5);
        cell5.setWidth("1300");
    }

    /**
     * 设置请求头
     * @param header
     * @param table
     * @param row
     */
    private static void setHeader(JSONObject header, XWPFTable table, int row) {
        XWPFTableCell cell0 = table.getRow(row).getCell(0);
        cell0.setWidth("1300");
        XWPFTableCell cell1 = table.getRow(row).getCell(1);
        cell1.setWidth("1300");
        cell1.addParagraph().createRun().setText((String)header.get("key"));
        XWPFTableCell cell2 = table.getRow(row).getCell(2);
        cell2.setWidth("1300");
        cell2.addParagraph().createRun().setText((String)header.get("type"));
        XWPFTableCell cell3 = table.getRow(row).getCell(3);
        mergeCellH(table,cell3,row,3,5);
        cell3.setWidth("3900");
        XWPFRun run = cell3.addParagraph().createRun();
        run.setText((String)header.get("value"));

    }

    /**
     * 合并列
     * @param table：表格对象
     * @param cell：合并起始单元格对象
     * @param row：行数
     * @param start：合并起始列
     * @param end：合并结束列
     */
    private static void mergeCellH(XWPFTable table, XWPFTableCell cell, int row, int start, int end) {
        cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
        for (int i = start + 1; i <= end; i++) {
            XWPFTableCell cellNext = table.getRow(row).getCell(i);
            cellNext.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
        }
    }

    /**
     * 合并行
     * @param table：表格对象
     * @param cell：合并起始单元格对象
     * @param col：列数
     * @param start：合并起始行
     * @param end：合并结束行
     */
    private static void mergeCellV(XWPFTable table, XWPFTableCell cell, int col, int start, int end) {
        cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
        for (int i = start + 1; i <= end; i++) {
            XWPFTableCell cellNext = table.getRow(i).getCell(col);
            cellNext.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
        }
    }

    /**
     * 导出word
     * @param document
     * @param savePath
     * @throws IOException
     */
    public static void saveDocument(XWPFDocument document, String savePath) throws IOException {
        File file = new File(savePath);
        OutputStream os = new FileOutputStream(file);
        document.write(os);
        os.close();
    }

    /**
     * word标题
     * @param document
     * @param title
     */
    public static void createTitleParagraph(XWPFDocument document,String title) {
        //新建一个标题段落对象（就是一段文字）
        XWPFParagraph titleParagraph = document.createParagraph();
        //样式居中
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        //创建文本对象
        XWPFRun titleFun = titleParagraph.createRun();
        //设置标题的名字
        titleFun.setText(title);
        //加粗
        titleFun.setBold(true);
        //设置颜色
        titleFun.setColor("000000");
        //字体大小
        titleFun.setFontSize(25);
        //换行
        titleFun.addBreak();
    }



    /**
     * 读取文件
     * 使用 Charset + CharsetDecoder 解决了中文乱码问题
     *
     * @param fis
     * @return
     */
    public static String read(FileInputStream fis) {
        StringBuilder stringBuilder = new StringBuilder();

        //解决中文乱码问题
        Charset charset = StandardCharsets.UTF_8;
        CharsetDecoder decoder = charset.newDecoder();
        char[] charCache = null;

        try{
            FileChannel fisChannel = fis.getChannel();
            //分配缓冲区、分配字符缓冲区解决中文乱码
            ByteBuffer byteBuffer = ByteBuffer.allocate(10240);
            CharBuffer charBuffer = CharBuffer.allocate(10240);

            //读取数据
            while (fisChannel.read(byteBuffer) != -1) {
                //上面把数据写入到了buffer，所以可知上面的buffer是写模式，调用flip把buffer切换到读模式，读取数据
                byteBuffer.flip();

                //把字节buffer解码到字符buffer
                decoder.decode(byteBuffer, charBuffer, true);

                //字符buffer切换到读模式
                charBuffer.flip();

                //存储字符
                charCache = new char[charBuffer.length()];
                while (charBuffer.hasRemaining()) {
                    charBuffer.get(charCache);
                }
                stringBuilder.append(charCache);

                //读完了buffer，清空buffer
                charBuffer.clear();
                byteBuffer.clear();
            }
        } catch (Exception e) {
            //log.info("读取文件异常,e={}", e.getMessage());
            return null;
        }

        return stringBuilder.toString();
    }
}
