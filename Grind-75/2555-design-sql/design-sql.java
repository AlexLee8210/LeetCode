class SQL {

    HashMap<String, HashMap<Integer, List<String>>> tables;
    HashMap<String, Integer> lengths;
    HashMap<String, Integer> ids;

    public SQL(List<String> names, List<Integer> columns) {
        tables = new HashMap<>();
        lengths = new HashMap<>();
        ids = new HashMap<>();

        for (int i = 0; i < names.size(); ++i) {
            tables.put(names.get(i), new HashMap<>());
            lengths.put(names.get(i), columns.get(i));
            ids.put(names.get(i), 0);
        }
    }
    
    public boolean ins(String name, List<String> row) {
        if (!tables.containsKey(name) || row.size() != lengths.get(name)) return false;
        int id = ids.get(name) + 1;
        HashMap<Integer, List<String>> table = tables.get(name);
        table.put(id, row);
        ids.put(name, id);
        return true;
    }
    
    public void rmv(String name, int rowId) {
        if (!tables.containsKey(name)) return;
        HashMap<Integer, List<String>> table = tables.get(name);

        if (!table.containsKey(rowId)) return;

        table.remove(rowId);
    }
    
    public String sel(String name, int rowId, int columnId) {
        if (!tables.containsKey(name)) return "<null>";
        HashMap<Integer, List<String>> table = tables.get(name);
        if (!table.containsKey(rowId)) return "<null>";

        List<String> row = table.get(rowId);
        if (columnId <= 0 || columnId > row.size()) return "<null>";

        return row.get(columnId - 1);
    }
    
    public List<String> exp(String name) {
        if (!tables.containsKey(name)) return null;
        HashMap<Integer, List<String>> table = tables.get(name);

        List<String> res = new ArrayList<String>(table.size());

        for (Integer id : table.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            List<String> row = table.get(id);
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