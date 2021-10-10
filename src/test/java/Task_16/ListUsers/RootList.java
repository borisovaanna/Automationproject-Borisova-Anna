package Task_16.ListUsers;

import lombok.Data;

import java.util.List;

@Data
public class RootList {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Datum> data;
    public SupportList support;
}
