package leetcode;

public class _551_学生出勤记录 {

    public boolean checkRecord(String s) {
        int lcount = 0;
        boolean a = false;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'A': {
                    if (a) {
                        return false;
                    }
                    a = true;
                    lcount=0;
                    break;
                }
                case 'L': {
                    if (lcount == 2) {
                        return false;
                    }
                    lcount++;
                    break;
                }
                case 'P': {
                    lcount=0;
                }
            }

        }
        return true;

    }
}
