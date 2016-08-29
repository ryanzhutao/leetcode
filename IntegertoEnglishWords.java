
public class IntegertoEnglishWords {

	public String numberToWords(int num) {
        String result = "";
        int remainder = 0;
        int billion = 0;
        int million = 0;
        int thousand = 0;
        if(num == 0){
            return "Zero";
        }
        billion = num/1000000000;
        if(billion > 0){
            result = onedigToStr(billion) + " Billion";
            remainder = num % 1000000000;
        }else{
            remainder = num;
        }
        million = remainder/1000000;
        if(million > 0){
            if(result.equals("")){
                result = threeDigToStr(million) + " Million";
            }else{
                result = result + " " + threeDigToStr(million) + " Million";
            }
            remainder = remainder % 1000000;
        }
        thousand = remainder/1000;
        if(thousand > 0){
             if(result.equals("")){
                 result = threeDigToStr(thousand) + " Thousand";
             }else{
                result = result + " " + threeDigToStr(thousand) + " Thousand";
             }
            remainder = remainder % 1000;
        }
        if(remainder!=0){
            if(result.equals("")){
                result = threeDigToStr(remainder);
            }else{
                result = result + " " + threeDigToStr(remainder);
            }
        }
        return result;
        
    }
    
    private String threeDigToStr(int num){
       String result = "";
       int hundred;
       int tenth;
       if(num > 0 && num < 10){
           result = onedigToStr(num);
       }else if(num >= 10 && num < 100){
           result = tenthToStr(num);
       }else if(num >= 100 & num < 1000){
           hundred = num /100;
           tenth = num % 100;
           result = onedigToStr(hundred) + " Hundred";
           if(tenth>=10){
               result = result + " " + tenthToStr(tenth);
           }else if(tenth > 0 && tenth < 10){
               result = result + " " + onedigToStr(tenth);
           }
       }
       return result;
    }
    
    private String onedigToStr(int num){
        String result = "";
        if(num == 1){
            result = "One"; 
        }else if(num == 2){
            result = "Two";
        }else if(num == 3){
            result = "Three";
        }else if(num == 4){
            result = "Four";
        }else if(num == 5){
            result = "Five";
        }else if(num == 6){
            result = "Six";
        }else if(num == 7){
            result = "Seven";
        }else if(num == 8){
            result = "Eight";
        }else if(num == 9){
            result = "Nine";
        }
        return result;
    }
    
    //
    private String tenthToStr(int num){
        String result = "";
        int diff = 0;
        if(num == 10){
            result = "Ten";
        }else if(num == 11){
            result = "Eleven";
        }else if(num == 12){
            result = "Twelve";
        }else if(num == 13){
            result = "Thirteen";
        }else if(num == 14){
            result = "Fourteen";
        }else if(num == 15){
            result = "Fifteen";
        }else if(num == 16){
            result = "Sixteen";
        }else if(num == 17){
            result = "Seventeen";
        }else if(num == 18){
            result = "Eighteen";
        }else if(num == 19){
            result = "Nineteen";
        }else{
            if(num >=20 & num < 30){
                diff = num - 20;
                result = "Twenty";
            }else if(num >=30 & num < 40){
                diff = num - 30;
                result = "Thirty";
            }else if(num >=40 & num < 50){
                diff = num - 40;
                result = "Forty";
            }else if(num >=50 & num < 60){
                diff = num - 50;
                result = "Fifty";
            }else if(num >=60 & num < 70){
                diff = num - 60;
                result = "Sixty";
            }else if(num >=70 & num < 80){
                diff = num - 70;
                result = "Seventy";
            }else if(num >=80 & num < 90){
                diff = num - 80;
                result = "Eighty";
            }else if(num >=90 & num < 100){
                diff = num - 90;
                result = "Ninety";
            }
            if(diff > 0){
                result = result + " " + onedigToStr(diff);
            }
        }
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
