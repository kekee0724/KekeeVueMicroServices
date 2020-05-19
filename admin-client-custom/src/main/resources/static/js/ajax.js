function showUpmenu(upmenu) {
  	var url = "getTopmenu1.asp?upmenu=" + escape(upmenu);
  	xmlHttp.open("GET", url, true);
	document.getElementById("showSubPage").innerHTML="<p class='subMenu'>Loading...</p>";
  	xmlHttp.onreadystatechange = updateUpmenu;
  	xmlHttp.send(null);
}





function updateUpmenu() {
  	if (xmlHttp.readyState == 4) {
    		var response = xmlHttp.responseText;
		var arrStr=response.split("|");
		document.getElementById("showSubPage").innerHTML=arrStr[0];
		try{	// try to show first class and first article (2006.11.30added)
			if(arrStr[2]!="0"){showArticle(arrStr[2]);}
			if(arrStr[1]!="0"){
				var laterShow="chengepic('" + arrStr[1] + "',0)";
				setTimeout(laterShow,2000);
			}
		}catch(Exception){}
  	}
}



