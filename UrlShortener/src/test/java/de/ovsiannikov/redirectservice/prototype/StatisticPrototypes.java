package de.ovsiannikov.redirectservice.prototype;

import de.ovsiannikov.redirectservice.dto.RedirectStatisticDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticPrototypes {

    static RedirectStatisticDto st1 = new RedirectStatisticDto("abc","microsoft", LocalDateTime.now());
    static RedirectStatisticDto st2 = new RedirectStatisticDto("ekl","google", LocalDateTime.now());
    static RedirectStatisticDto st3 = new RedirectStatisticDto("mno","apple", LocalDateTime.now());


    public static List<RedirectStatisticDto> redirectStatisticDtoListFromKafka() {

        List<RedirectStatisticDto> list = Collections.EMPTY_LIST;

        return list;
    }

    public static List<RedirectStatisticDto> redirectStatisticDtoListFromKafka_1() {

        List<RedirectStatisticDto> list1 = new ArrayList<>();
        list1.add(st1);
        list1.add(st1);
        list1.add(st1);

        return list1;
    }

    public static List<RedirectStatisticDto> redirectStatisticDtoListFromKafka_2() {
        List<RedirectStatisticDto> list2 = new ArrayList<>();
        list2.add(st1);
        list2.add(st1);
        list2.add(st1);
        list2.add(st2);
        list2.add(st2);

        return list2;
    }

    public static List<RedirectStatisticDto> redirectStatisticDtoListFromKafka_3() {
        List<RedirectStatisticDto> list3 = new ArrayList<>();
        list3.add(st1);
        list3.add(st2);
        list3.add(st2);
        list3.add(st3);
        list3.add(st3);
        list3.add(st3);
        list3.add(st3);

        return list3;
    }
}
