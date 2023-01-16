//package itg.hbase;
//
//import cn.hutool.extra.spring.SpringUtil;
//import org.apache.hadoop.hbase.Cell;
//import org.apache.hadoop.hbase.HColumnDescriptor;
//import org.apache.hadoop.hbase.HTableDescriptor;
//import org.apache.hadoop.hbase.TableName;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.filter.CompareFilter;
//import org.apache.hadoop.hbase.filter.RowFilter;
//import org.apache.hadoop.hbase.filter.SubstringComparator;
//import org.apache.hadoop.hbase.util.Bytes;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NavigableMap;
//
//public class HbaseUtil {
//    private static final HbaseConfig hbaseConfig = SpringUtil.getBean("hbaseConfig");
//    private static Connection connection = null;
//    private static Admin admin = null;
//
//    private HbaseUtil() {
//        if (connection == null) {
//            try {
//                connection = hbaseConfig.getConnection();
//                admin = connection.getAdmin();
//            } catch (IOException e) {
//
//            }
//        }
//    }
//
//    /**
//     * 创建表
//     *
//     * @param tableName    表名
//     * @param columnFamily 列族（数组）
//     */
//    public void createTable(String tableName, String[] columnFamily) throws IOException {
//        TableName name = TableName.valueOf(tableName);
//        //如果存在则删除
//        if (admin.tableExists(name)) {
//            admin.disableTable(name);
//            admin.deleteTable(name);
//        } else {
//            HTableDescriptor desc = new HTableDescriptor(name);
//            for (String cf : columnFamily) {
//                desc.addFamily(new HColumnDescriptor(cf));
//            }
//            admin.createTable(desc);
//        }
//    }
//
//    /**
//     * 插入记录（单行单列族-多列多值）
//     *
//     * @param tableName     表名
//     * @param row           行名
//     * @param columnFamilys 列族名
//     * @param columns       列名（数组）
//     * @param values        值（数组）（且需要和列一一对应）
//     */
//    public void insertRecords(String tableName, String row, String columnFamilys, String[] columns, String[] values) throws IOException {
//        TableName name = TableName.valueOf(tableName);
//        Table table = connection.getTable(name);
//        Put put = new Put(Bytes.toBytes(row));
//        for (int i = 0; i < columns.length; i++) {
//            put.addColumn(Bytes.toBytes(columnFamilys), Bytes.toBytes(columns[i]), Bytes.toBytes(values[i]));
//            table.put(put);
//        }
//    }
//
//    /**
//     * 插入记录（单行单列族-单列单值）
//     *
//     * @param tableName    表名
//     * @param row          行名
//     * @param columnFamily 列族名
//     * @param column       列名
//     * @param value        值
//     */
//    public void insertOneRecord(String tableName, String row, String columnFamily, String column, String value) throws IOException {
//        TableName name = TableName.valueOf(tableName);
//        Table table = connection.getTable(name);
//        Put put = new Put(Bytes.toBytes(row));
//        put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));
//        table.put(put);
//    }
//
//    /**
//     * 删除一行记录
//     *
//     * @param tablename 表名
//     * @param rowkey    行名
//     */
//    public void deleteRow(String tablename, String rowkey) throws IOException {
//        TableName name = TableName.valueOf(tablename);
//        Table table = connection.getTable(name);
//        Delete d = new Delete(rowkey.getBytes());
//        table.delete(d);
//    }
//
//    /**
//     * 删除单行单列族记录
//     *
//     * @param tablename    表名
//     * @param rowkey       行名
//     * @param columnFamily 列族名
//     */
//    public void deleteColumnFamily(String tablename, String rowkey, String columnFamily) throws IOException {
//        TableName name = TableName.valueOf(tablename);
//        Table table = connection.getTable(name);
//        Delete d = new Delete(rowkey.getBytes()).addFamily(Bytes.toBytes(columnFamily));
//        table.delete(d);
//    }
//
//    /**
//     * 删除单行单列族单列记录
//     *
//     * @param tablename    表名
//     * @param rowkey       行名
//     * @param columnFamily 列族名
//     * @param column       列名
//     */
//    public void deleteColumn(String tablename, String rowkey, String columnFamily, String column) throws IOException {
//        TableName name = TableName.valueOf(tablename);
//        Table table = connection.getTable(name);
//        Delete d = new Delete(rowkey.getBytes()).addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column));
//        table.delete(d);
//    }
//
//    /**
//     * 查找一行记录
//     *
//     * @param tablename 表名
//     * @param rowKey    行名
//     */
//    public static String selectRow(String tablename, String rowKey) throws IOException {
//        String record = "";
//        TableName name = TableName.valueOf(tablename);
//        Table table = connection.getTable(name);
//        Get g = new Get(rowKey.getBytes());
//        Result rs = table.get(g);
//        NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> map = rs.getMap();
//        for (Cell cell : rs.rawCells()) {
//            StringBuffer stringBuffer = new StringBuffer().append(Bytes.toString(cell.getRowArray())).append("\t")
//                    .append(Bytes.toString(cell.getFamilyArray())).append("\t")
//                    .append(Bytes.toString(cell.getQualifierArray())).append("\t")
//                    .append(Bytes.toString(cell.getValueArray())).append("\n");
//            String str = stringBuffer.toString();
//            record += str;
//        }
//        return record;
//    }
//
//    /**
//     * 查找单行单列族单列记录
//     *
//     * @param tablename    表名
//     * @param rowKey       行名
//     * @param columnFamily 列族名
//     * @param column       列名
//     * @return
//     */
//    public static String selectValue(String tablename, String rowKey, String columnFamily, String column) throws IOException {
//        TableName name = TableName.valueOf(tablename);
//        Table table = connection.getTable(name);
//        Get g = new Get(rowKey.getBytes());
//        g.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column));
//        Result rs = table.get(g);
//        return Bytes.toString(rs.value());
//    }
//
//    /**
//     * 查询表中所有行（Scan方式）
//     *
//     * @param tablename
//     * @return
//     */
//    public String scanAllRecord(String tablename) throws IOException {
//        String record = "";
//        TableName name = TableName.valueOf(tablename);
//        Table table = connection.getTable(name);
//        Scan scan = new Scan();
//        ResultScanner scanner = table.getScanner(scan);
//        try {
//            for (Result result : scanner) {
//                for (Cell cell : result.rawCells()) {
//                    StringBuffer stringBuffer = new StringBuffer().append(Bytes.toString(cell.getRowArray())).append("\t")
//                            .append(Bytes.toString(cell.getFamilyArray())).append("\t")
//                            .append(Bytes.toString(cell.getQualifierArray())).append("\t")
//                            .append(Bytes.toString(cell.getValueArray())).append("\n");
//                    String str = stringBuffer.toString();
//                    record += str;
//                }
//            }
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }
//        return record;
//    }
//
//    /**
//     * 根据rowkey关键字查询报告记录
//     *
//     * @param tablename
//     * @param rowKeyword
//     * @return
//     */
//    public List scanReportDataByRowKeyword(String tablename, String rowKeyword) throws IOException {
//        ArrayList<String> list = new ArrayList<>();
//
//        Table table = connection.getTable(TableName.valueOf(tablename));
//        Scan scan = new Scan();
//
//        //添加行键过滤器，根据关键字匹配
//        RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator(rowKeyword));
//        scan.setFilter(rowFilter);
//
//        ResultScanner scanner = table.getScanner(scan);
//        try {
//            for (Result result : scanner) {
//                //TODO 此处根据业务来自定义实现
//                list.add(null);
//            }
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }
//        return list;
//    }
//
//    /**
//     * 根据rowkey关键字和时间戳范围查询报告记录
//     *
//     * @param tablename
//     * @param rowKeyword
//     * @return
//     */
//    public List scanReportDataByRowKeywordTimestamp(String tablename, String rowKeyword, Long minStamp, Long maxStamp) throws IOException {
//        ArrayList<String> list = new ArrayList<>();
//
//        Table table = connection.getTable(TableName.valueOf(tablename));
//        Scan scan = new Scan();
//        //添加scan的时间范围
//        scan.setTimeRange(minStamp, maxStamp);
//
//        RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator(rowKeyword));
//        scan.setFilter(rowFilter);
//
//        ResultScanner scanner = table.getScanner(scan);
//        try {
//            for (Result result : scanner) {
//                list.add(null);
//            }
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }
//        return list;
//    }
//
//    /**
//     * 删除表操作
//     *
//     * @param tablename
//     */
//    public void deleteTable(String tablename) throws IOException {
//        TableName name = TableName.valueOf(tablename);
//        if (admin.tableExists(name)) {
//            admin.disableTable(name);
//            admin.deleteTable(name);
//        }
//    }
//}
