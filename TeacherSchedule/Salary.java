public class Salary{
    
    private int year;
    private int ba;
    private int ma;
    private int phd;

    public Salary(int y, int b, int m, int p){
        year = y;
        ba = b;
        ma = m;
        phd = p;
    }

    public Salary(String str){
        year = Integer.parseInt(str.substring(2,4).trim());
        ba = Integer.parseInt(str.substring(7, 13).trim());
        ma = Integer.parseInt(str.substring(16,22).trim());
        phd = Integer.parseInt(str.substring(25,31).trim());
    }

    public int getYear(){
        return year;
    }
    public int getBA(){
        return ba;
    }
    public int getMA(){
        return ma;
    }
    public int getPHD(){
        return phd;
    }

    public String toString(){
        String str = "| ";
        if (year < 10){
            str += "0";
        }
        str += Integer.toString(year);
        str += " | ";
        str += Integer.toString(ba);
        if (ba <= 99999){
            str += " ";
        }
        str += " | ";
        str += Integer.toString(ma);
        if (ma <= 99999){
            str += " ";
        }
        str += " | ";
        str += Integer.toString(phd);
        if (phd <= 99999){
            str += " ";
        }
        str += " | ";
        return str;
    }
}