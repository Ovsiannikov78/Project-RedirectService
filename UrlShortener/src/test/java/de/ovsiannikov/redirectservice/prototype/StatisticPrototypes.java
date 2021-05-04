package de.ovsiannikov.redirectservice.prototype;

import de.ovsiannikov.redirectservice.dto.RedirectStatisticDto;
import de.ovsiannikov.redirectservice.dto.StatisticDto;
import de.ovsiannikov.redirectservice.entity.RedirectStatistic;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticPrototypes {

    static RedirectStatisticDto st1 = new RedirectStatisticDto("abc","microsoft", LocalDateTime.now());
    static RedirectStatisticDto st2 = new RedirectStatisticDto("ekl","google", LocalDateTime.now());
    static RedirectStatisticDto st3 = new RedirectStatisticDto("mno","apple", LocalDateTime.now());


    static StatisticDto st4 = new StatisticDto("url","netflix",10L);
    static StatisticDto st5 = new StatisticDto("gdr","berlin",23L);
    static StatisticDto st6 = new StatisticDto("aus","australia",3L);
    static StatisticDto st7 = new StatisticDto("abc","microsoft",12L);
    static StatisticDto st8 = new StatisticDto("ekl","google",5L);
    static StatisticDto st9 = new StatisticDto("mno","apple",8L);

    static RedirectStatistic rd1 = new RedirectStatistic("gdr","berlin",23L);
    static RedirectStatistic rd2 = new RedirectStatistic("abc","microsoft",12L);
    static RedirectStatistic rd3 = new RedirectStatistic("url","netflix",10L);
    static RedirectStatistic rd4 = new RedirectStatistic("mno","apple",8L);
    static RedirectStatistic rd5 = new RedirectStatistic("ekl","google",5L);
    static RedirectStatistic rd6 = new RedirectStatistic("aus","australia",3L);


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

    public static List<StatisticDto> top5ShortUrlList_Empty() {

        List<StatisticDto> list = Collections.EMPTY_LIST;

        return list;
    }

    public static List<StatisticDto> top5ShortUrlList_2() {

        List<StatisticDto> list = new ArrayList<>();
        list.add(st4);

        return list;
    }

    public static List<StatisticDto> top5ShortUrlList_3() {

        List<StatisticDto> list = new ArrayList<>();
        list.add(st5);
        list.add(st7);
        list.add(st4);
        list.add(st9);
        list.add(st8);

        return list;
    }

    public static List<StatisticDto> top5ShortUrlList_4() {

        List<StatisticDto> list = new ArrayList<>();
        list.add(st5);
        list.add(st7);
        list.add(st4);
        list.add(st9);
        list.add(st8);
        list.add(st6);

        return list;
    }

    public static List<RedirectStatistic> redirectStatisticList() {

        List<RedirectStatistic> list = new ArrayList<>();
        list.add(rd1);
        list.add(rd2);
        list.add(rd3);
        list.add(rd4);
        list.add(rd5);
        list.add(rd6);

        return list;
    }

}
