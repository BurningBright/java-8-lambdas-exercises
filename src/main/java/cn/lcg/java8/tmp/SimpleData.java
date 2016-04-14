package cn.lcg.java8.tmp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
/**
 * @Description:简单数据
 * @author leon
 * @date 2016年4月13日 下午1:09:48
 */
public class SimpleData {
    public static final Engineer DavidBrevik = new Engineer("David Brevik", "Blizzar");
    public static final Engineer ErichSchaefer = new Engineer("Erich Schaefer", "Blizzar");
    public static final Engineer MaxSchaefer = new Engineer("Max Schaefer", "Blizzar");

    public static final List<Engineer> memberOfDiablo = Arrays.asList(DavidBrevik, ErichSchaefer, MaxSchaefer);
    
    public static final Engineer diabloGroup = new Engineer("diabloGroup", memberOfDiablo, "Blizzar");

    public static final Platform diablo_1 = new Platform("Diablo One", asList(
            new System_("Level", 10), new System_("Weapon", 59)), memberOfDiablo);
    public static final Platform diablo_2 = new Platform("Diablo Two", asList(
            new System_("Log", 32), new System_("Weapon", 55)), memberOfDiablo);
    public static final Platform diablo_3 = new Platform("Diablo Three",
            asList(new System_("Level", 15), new System_("Log", 37),
                    new System_("Weapon", 55)), memberOfDiablo);
    
    public static Stream<Engineer> threeEngineer() {
        return Stream.of(DavidBrevik, ErichSchaefer, MaxSchaefer);
    }
    
    public static List<Engineer> getThreeEngineer() {
        return Arrays.asList(DavidBrevik, ErichSchaefer, MaxSchaefer);
    }
}
