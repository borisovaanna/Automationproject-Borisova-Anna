package Task_16.ListResource;

import lombok.Data;

import java.util.List;

@Data
public class RootListResource {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<DatumListResource> data;
    public SupportListResource support;

}
