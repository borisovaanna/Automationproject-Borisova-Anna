import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    @Test
    public void test1(){
        List<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(0);
            add(-1);
            add(10);
            add(11);
            add(-20);
            add(40);
        }};

        List<Integer> newList = new ArrayList<>() {{
            addAll(list.stream().filter(data -> data != 0).filter(data -> data % 5 == 0).filter(data -> data % 10 == 0).collect(Collectors.toList()));
        }};
        System.out.print(newList);
    }
}
