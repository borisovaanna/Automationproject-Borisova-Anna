package Task_16.DelayedResponse;

import lombok.Data;

import java.util.List;

@Data
public class RootDelayResponse {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<DatumDelayResponse> data;
    public SupportDelayResponse support;

}
