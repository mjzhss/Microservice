import java.util.Calendar;

/**
 * 今日待完成事情
 * need to be dealt with
 * @author zhou 20190216 11:03:00
 * @version 0.1.0
 */
public class TodayPlan {
    /**
     * 小时
     */
    private static int hour;
    /**
     * 星期
     */
    private static int  weekDay;
    /**
     * 周
     */
    private static int  week;
    /**
     * 天
     */
    private static int  day;
    /**
     * 月
     */
    private static int  month;
    /**
     * 年
     */
    private static int  year;
    /**
     * 待办事项
     */
    private static String[] plans;
    private static String[] monthPlans;
    private static String[] yearPlans;

    public TodayPlan() {
        Calendar calendar = Calendar.getInstance();
        plans = new String[24];
        monthPlans = new String[13];
        yearPlans = new String[2100];
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        week = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        plans[6] = "学习新技术-新框架-SpringBoot";
        plans[7] = "复盘";
        plans[8] = "学习框架-基础框架-Spring";
        plans[9] = "复盘";
        plans[17] = "电影";
        plans[18] = "电影";
        plans[19] = "锻炼";
        plans[20] = "学习新技术-新框架-SpringBoot";
        plans[21] = "看视频";
        monthPlans[2] = "学习SpringBoot";
        monthPlans[3] = "学习SpringBoot";
        yearPlans[2019] = "年薪20万";
    }

    public static void main(String[] args) {
        TodayPlan todayPlan = new TodayPlan();
        todayPlan.getDayPlan();
        todayPlan.getMonthPlan();
        todayPlan.getYearPlan();
    }

    /**
     * 获取日计划
     */
    private void getDayPlan(){
        System.out.println("********************今日完成计划*********************");
        weekMathing();
        weekDayMatching();
        System.out.println("********************今日完成计划*********************");
    }

    /**
     * 获取月计划
     */
    private void getMonthPlan(){
        System.out.println();
        System.out.println("********************本月完成计划*********************");
        monthMathing();
        System.out.println("********************本月完成计划*********************");
    }

    /**
     * 获取今年计划
     */
    private void getYearPlan(){
        System.out.println();
        System.out.println("********************今年完成计划*********************");
        yearMatching();
        System.out.println("********************今年完成计划*********************");
    }

    /**
     * 洗澡（星期二，星期四，星期日），洗衣服（星期四，星期日）
     */
    private void weekDayMatching() {
        final String[] weekDayPlans = {
                "洗澡", "洗衣服"
        };
        if(weekDay == 1 || weekDay == 3 || weekDay == 5) {
            plans[20] = weekDayPlans[0];
            if(weekDay == 1 || weekDay == 5) {
                plans[21] = weekDayPlans[1];
            }
        }
        if(weekDay != 1 && weekDay != 7) {
            plans[8] = "";
            plans[9] = "";
            plans[17] = "";
            plans[18] = "";
        }
        printPlan(plans, 0, "点");
    }

    /**
     * 周末
     * 买水果（星期日）, 买牛奶（第一个星期日），大扫除（第二个星期日）
     */
    private void weekMathing() {
        final String[] weekPlans = {
                "买牛奶", "大扫除"
        };
        String[] others = new String[10];
        if(weekDay == 1 || weekDay == 7) {
            if(weekDay == 1) {
                others[0] = "买水果";
                if(week <= weekPlans.length) {
                    others[1] = weekPlans[week-1];
                }
            }
            others[2] = "跑步一小时";
            others[3] ="学习经济学";
        }
        printPlan(others, 0, null);
    }

    /**
     * 本月计划
     */
    private void monthMathing() {
        printPlan(monthPlans, month, "月");
    }

    /**
     * 今年计划
     */
    private void yearMatching() {
        printPlan(yearPlans, year, "年");
    }

    /**
     * 打印计划
     */
    private void printPlan(String[] strs, int init, String name) {
        StringBuffer str;
        int length = strs.length;
        for (int i = init; i < length; i++) {
            String plan = strs[i];
            if(!"".equals(plan) && plan != null) {
                str = new StringBuffer(10);
                if(!"".equals(name) && name != null) {
                    str.append(i).append(name).append(": ");
                }
                str.append(plan);
                System.out.println(str.toString());
            }
        }
    }
}
