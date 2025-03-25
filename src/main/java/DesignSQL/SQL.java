package DesignSQL;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SQL {
    Map<String, Integer> tableRowIdSequence = new HashMap<>();

    Map<String, List<Integer>> tableColumns = new HashMap<>();

    Map<String, Map<Integer, List<String>>> tableData = new HashMap<>();

    public SQL(List<String> names, List<Integer> columns) {
        for(String tableName: names){
            tableColumns.put(tableName, new ArrayList<>(columns));
        }
    }

    public boolean ins(String name, List<String> row) {
        int rowId = 1;
        if(tableRowIdSequence.containsKey(name)){
            rowId = tableRowIdSequence.get(name) + 1;
        }

        if(!tableColumns.containsKey(name) ||
            tableColumns.get(name).size() != row.size()){
            return false;
        }

        Map<Integer, List<String>> rowData = new HashMap<>();

        rowData.put(rowId, new ArrayList<>(row));

        tableData.put(name, rowData);
        tableRowIdSequence.put(name, rowId);
        return true;
    }

    public void rmv(String name, int rowId) {
        if(!tableData.containsKey(name))
            return;

        Map<Integer, List<String>> rowData = tableData.get(name);

        if(!rowData.containsKey(rowId))
            return;

        rowData.remove(rowId);
    }

    public String sel(String name, int rowId, int columnId) {
        if(!tableData.containsKey(name))
            return null;

        Map<Integer, List<String>> rowData = tableData.get(name);

        if(!rowData.containsKey(rowId))
            return null;

        List<Integer> columnIds =  tableColumns.get(name);

        int index=0;
        for(Integer id: columnIds){
            if(id.equals(columnId)){
                index++;
                break;
            }
            index++;
        }

        List<String> columns = rowData.get(rowId);

        return columns.get(index);
    }

    public List<String> exp(String name) {
        if(!tableData.containsKey(name))
            return null;

        Map<Integer, List<String>> rowData = tableData.get(name);

        List<String> res = new ArrayList<>();

        for(Map.Entry<Integer, List<String>> entry: rowData.entrySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey()).append(',');

            for(String str: entry.getValue()){
                sb.append(str).append(',');
            }
            res.add(sb.toString());
        }
        return res;
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * boolean param_1 = obj.ins(name,row);
 * obj.rmv(name,rowId);
 * String param_3 = obj.sel(name,rowId,columnId);
 * List<String> param_4 = obj.exp(name);
 */
