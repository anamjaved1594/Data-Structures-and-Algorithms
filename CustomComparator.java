import java.util.*;


class CustomComparator implements Comparator<Edge>{
@Override
public int compare(Edge o1, Edge o2) {
    Double n1 = o1.getWeight();
    Double n2 = o2.getWeight();
    return n1.compareTo(n2);
}
}
