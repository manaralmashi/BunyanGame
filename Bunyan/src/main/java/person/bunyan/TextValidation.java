/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;



import java.util.regex.Pattern;

public class TextValidation {
    private Pattern pattern;
    
    public boolean ContainSpaces(String text ){
        return text.contains(" ");
    }
    
    public boolean validLen(String text ){
        if (text.length()>50){
            return false;
        }
        return true;
    }
    
    public boolean validEmailFormat(String text ){
        String emailFormat = "^[a-zA-Z0-9]+@[a-zA-Z]{3,10}.(com|co.in|co.au)$";
        pattern = Pattern.compile(emailFormat);
        return pattern.matcher(text).matches();
    }
    
    
    public boolean validPassFormat(String text ){
        String passFormat = "^[a-zA-Z]+[0-9]+[a-zA-Z]*$";
        pattern = Pattern.compile(passFormat);
        return pattern.matcher(text).matches();
    }
      public boolean ContainSpicalChar(String text ){
       if(text.contains(";")){
           return false;
       }else if(text.contains("$")){
           return false;
       } else if(text.contains("#")){
           return false;
       } else if(text.contains("*")){
           return false;
       }else if(text.contains("^")){
           return false;
       }else if(text.contains("?")){
           return false;
       }else if(text.contains("!")){
           return false;
       }else if(text.contains("-")){
           return false;
       }else if(text.contains("_")){
           return false;
       }
        return true;
    }      
}

