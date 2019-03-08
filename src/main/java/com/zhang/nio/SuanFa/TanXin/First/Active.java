package com.zhang.nio.SuanFa.TanXin.First;

import java.util.ArrayList;
import java.util.List;

public class Active implements Comparable<Active> {
    private int startTime;//活动开始时间
    private int endTime;//活动结束时间

    public Active(int startTime, int endTime) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Active [startTime=" + startTime + ", endTime=" + endTime + "]";
    }

    //活动排序时按照结束时间升序
    @Override
    public int compareTo(Active o) {
        if (this.endTime > o.getEndTime()) {
            return 1;
        } else if (this.endTime == o.endTime) {
            return 0;
        } else {
            return -1;
        }
    }
    /**
     *
     * @param actives
     *            活动集合
     * @param startTime
     *            教室的开始使用时间
     * @param endTime
     *            教室的结束使用时间
     * @return
     */
    public static List<Active> getBestActives(List<Active> actives, int startTime, int endTime) {
        //最佳活动选择集合
        List<Active> bestActives = new ArrayList<>();
        //将活动按照最早结束时间排序
        actives.sort(null);
        //nowTime 用来记录上次活动结束时间
        int nowTime = startTime;
        /**
         * 因为我们已经按照最早结束时间排序，那么只要活动在时间范围内
         * actives.get(1)就应当是第一个活动的结束时间.
         * 则我们记录第一次活动结束的时间，在结合剩下的活动中，
         * 选取开始时间大于nowTime且结束时间又在范围内的活动，则为第二次活动时间，
         * 知道选出所有活动
         */
        for (int i = 0; i < actives.size(); i++) {
            Active act = actives.get(i);
            if(act.getStartTime()>=nowTime&&act.getEndTime()<=endTime){
                bestActives.add(act);
                nowTime = act.getEndTime();
            }
        }
        return bestActives;
    }
}