package cn.lcg.java8.tmp;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 
* @Description: Domain class for a system engineer.
*   描述工程师或工程师团队
* @author leon
* @date 2016年3月4日 上午11:16:31
*
 */
public class Engineer {

    private String name;
    private List<Engineer> members;
    private String company;

    public Engineer(String name, String company) {
        this(name, Collections.emptyList(), company);
    }

    public Engineer(String name, List<Engineer> members, String company) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(company);
        this.name = name;
        this.members = new ArrayList<Engineer>(members);
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Stream<Engineer> getMembers() {
        return members.stream();
    }

    public String getCompany() {
        return company;
    }



    public boolean isSolo() {
        return members.isEmpty();
    }

    public boolean isFrom(String company) {
        return this.company.equals(company);
    }

    @Override
    public String toString() {
        return getName();
    }

    public Engineer copy() {
        List<Engineer> members = getMembers().map(Engineer::copy).collect(toList());
        return new Engineer(name, members, company);
    }
}
