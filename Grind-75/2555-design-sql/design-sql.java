class SQL {

    HashMap<String, List<List<String>>> tables;
    HashMap<String, Integer> lengths;

    public SQL(List<String> names, List<Integer> columns) {
        tables = new HashMap<>();
        lengths = new HashMap<>();

        for (int i = 0; i < names.size(); ++i) {
            tables.put(names.get(i), new ArrayList<>());
            lengths.put(names.get(i), columns.get(i));
        }
    }
    
    public boolean ins(String name, List<String> row) {
        if (!tables.containsKey(name) || row.size() != lengths.get(name)) return false;
        List<List<String>> table = tables.get(name);
        table.add(row);
        return true;
    }
    
    public void rmv(String name, int rowId) {
        if (!tables.containsKey(name)) return;
        List<List<String>> table = tables.get(name);
        --rowId;

        if (rowId < 0 || rowId >= table.size() || table.get(rowId) == null) return;

        table.set(rowId, null);
    }
    
    public String sel(String name, int rowId, int columnId) {
        if (!tables.containsKey(name)) return "<null>";
        List<List<String>> table = tables.get(name);
        --rowId;

        if (rowId < 0 || rowId >= table.size() || table.get(rowId) == null) return "<null>";

        List<String> row = table.get(rowId);
        if (columnId <= 0 || columnId > row.size()) return "<null>";

        return row.get(columnId - 1);
    }
    
    public List<String> exp(String name) {
        if (!tables.containsKey(name)) return null;
        List<List<String>> table = tables.get(name);

        List<String> res = new ArrayList<String>(table.size());

        for (int id = 1; id <= table.size(); ++id) {
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            List<String> row = table.get(id - 1);
            if (row == null) continue;

            for (String s : row) {
                sb.append(',').append(s);
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