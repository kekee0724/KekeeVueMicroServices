function   IsNum(s)   
  {   
  var   Number   =   "0123456789.";   
  for   (i   =   0;   i   <   s.length;i++)   
      {      
          var   c   =   s.charAt(i);   
          
          if   (Number.indexOf(c)   ==   -1)   return   false;   
      }   
  return   true;   
  
  }   
  
  
  function trim(s) {
  var count = s.length;
  var st    = 0;       
  
  var end   = count-1; 

  if (s == "") return s;
  while (st < count) {
    if (s.charAt(st) == " ")
      st ++;
    else
      break;
  }
  while (end > st) {
    if (s.charAt(end) == " ")
      end --;
    else
      break;
  }
  return s.substring(st,end + 1);
}


function calculate_byte( sTargetStr ) {
         var sTmpStr, sTmpChar;
         var nOriginLen = 0;
         var nStrLength = 0;
         
         sTmpStr = new String(sTargetStr);
         nOriginLen = sTmpStr.length;

         for ( var i=0 ; i < nOriginLen ; i++ ) {
                 sTmpChar = sTmpStr.charAt(i);

                 if (escape(sTmpChar).length > 4) {
                         nStrLength += 2;
                 } else if (sTmpChar!='\r') {
                         nStrLength ++;
                 }
         }
        
         return nStrLength; 
        
}



function isEmail(vEMail)
{
 var regInvalid=/(@.*@)|(\.\.)|(@\.)|(\.@)|(^\.)/;
 var regValid=/^.+\@(\[?)[a-zA-Z0-9\-\.]+\.([a-zA-Z]{2,3}|[0-9]{1,3})(\]?)$/;
 return (!regInvalid.test(vEMail)&&regValid.test(vEMail));
}

  
  
 function isValidDate(dateStr) {
        var matchArray = dateStr.match(/^[0-9]+-[0-1][0-9]-[0-3][0-9]$/)
        if (matchArray == null) {
            return false;
        }
        return true;
   }