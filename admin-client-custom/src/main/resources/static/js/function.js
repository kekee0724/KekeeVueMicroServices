
function getObject(objectId) {
     if(document.getElementById && document.getElementById(objectId)) {
	// W3C DOM
	   return document.getElementById(objectId);
     } 
     else if (document.all && document.all(objectId)) {
	// MSIE 4 DOM
	   return document.all(objectId);
     } 
     else if (document.layers && document.layers[objectId]) {
	// NN 4 DOM.. note: this won't find nested layers
	   return document.layers[objectId];
     } 
     else {
	   return false;
    }
} 

var responsecont;
var xmlHttp;
var xH=new Object();
var rqtp=new Object();
var dateStr,dStr;
var requestType;
var etype=0;
var newsstring;
var ajccache=new Object();
var url;
var MouseDelayTime=200;//鼠标感应延迟
var waitInterval;
var Browser = new Object();
Browser.isMozilla = (typeof document.implementation != 'undefined') && (typeof document.implementation.createDocument != 'undefined') && (typeof HTMLDocument!='undefined');
Browser.isIE = window.ActiveXObject ? true : false;
Browser.isFirefox = (navigator.userAgent.toLowerCase().indexOf("firefox")!=-1);
Browser.isOpera = (navigator.userAgent.toLowerCase().indexOf("opera")!=-1);

function SetCookie(name,value,expires){//写cookie
var exp=new Date();
exp.setTime(exp.getTime()+expires*60000);
document.cookie=name+"="+escape(value)+";expires="+exp.toGMTString();//+";domain=arkoo.com;path=/";
} 
function readcookie(name){//读取cookie
var oRegex=new RegExp(name+'=([^;]+)','i');
var oMatch=oRegex.exec(document.cookie);
if(oMatch&&oMatch.length>1)return unescape(oMatch[1]);
else return '';
}

function CreateXMLHttpRequest(){
   // Initialize Mozilla XMLHttpRequest object
   if (window.XMLHttpRequest){
       xmlHttp = new XMLHttpRequest();
   } 
   // Initialize for IE/Windows ActiveX version
   else if (window.ActiveXObject) {
       try{
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP.3.0");
	   } 
       catch (e){
			try{
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e){newsstring = "<div class='loading'>Loading rquest content fail, Please try it again latter...</div>";}
       }
   }
}

function getnews(tagid,x){
url = "tab/"+tagid+'_'+x+'.asp';
var url2=url;
requestType = tagid;
if(ajccache[url]==null){
var loadstatustext="<div class='loading'><img src='tab/images/loading.gif' /> Loading request content, please wait...</div>";
rqtp[tagid]=tagid;
CreateXMLHttpRequest();   
var hdr=tagid;
   xH[tagid]=xmlHttp;
   if(etype==1)getObject(requestType+'_cnt').innerHTML = loadstatustext;
   xH[tagid].onreadystatechange = function(){
   // only if xmlHttp shows "complete"
   if (xH[tagid].readyState == 4){
      // only http 200 to process
      if (window.location.href.indexOf("http")==-1 || xH[tagid].status == 200){
         newsstring = xH[tagid].responseText;
    dateStr=xH[tagid].getResponseHeader("Date");
    dStr = new Date(dateStr);SetCookie('dStr',dStr,10000000);
         //inject centent to tab-pane
            shownews(rqtp[tagid],newsstring);
            ajccache[url2]=newsstring;
      }
   }
}
   xH[tagid].open("GET", url, true);
   xH[tagid].setRequestHeader("If-Modified-Since","0");
   xH[tagid].send(null);
}
else
{shownews(requestType,ajccache[url]);}
}

function shownews(requestType,newsstring){
//<![CDATA[
    responsecont = getObject(requestType+'_cnt');
    responsecont.innerHTML = newsstring;
    getObject("pdate").innerHTML=dStr;
if(getObject("alta")){ata(getObject("alta"));hideText();}
//]]>
}


function TabNews(tagid,x){
	var lim=getObject(tagid+"_mn").getElementsByTagName('li');
	var mnt=getObject(tagid+"_mn").getElementsByTagName('li').length;
	if(!mnt)mnt=4;
	for(var i=0;i<mnt;i++){
		if(i == (x-1)){
			if(i==0){
				lim[i].className="tabactive1";
			}
			else{
				lim[i].className="tabactive2";
				lim[i-1].getElementsByTagName('a')[0].style.background="url()";
			}
			lim[i].getElementsByTagName('a')[0].style.background="url(tab/images/tab_bgs.gif) right -60px no-repeat";
			try{getnews(tagid,x);}catch(e){alert(e);}
		}	
		else{
			lim[i].className="";
			lim[i].getElementsByTagName('a')[0].style.background="url(tab/images/tab_bgs.gif) right -88px no-repeat";		
		}
	}
}

var idn,tmpa,tmpat;
var aw="";
var rT;
function aet(tagid,etp){
var lis=getObject(tagid+"_mn").getElementsByTagName('li');
var wts=tagid+"_cnt";
var wnf=tagid+"info";
if(readcookie(tagid+"_cntd")=="none"){
	hiddenList(getObject(wts));
	maxh[wts]=readcookie(tagid+"_cnth");
	getObject("pdate").innerText=readcookie("dStr");
	}
else{
	if(parseInt(readcookie(wnf))>1)
	TabNews(tagid,readcookie(wnf));//返回上次访问
	else
	TabNews(tagid,1);
	if(etp==1)aw=tagid+readcookie(wnf);
}
	for(var iy=0;iy<lis.length;iy++){
		with(lis[iy]){
		if(etp==0){
		lis[iy].onmouseover=function(){
			rT=attributes.getNamedItem('id').value.substring(0, attributes.getNamedItem('id').value.length-1);
			if(getObject(rT+'_cnt').style.display != "none"&&className!="") return;
			idn=parseInt(attributes.getNamedItem('id').value.substring(attributes.getNamedItem('id').value.length-1, attributes.getNamedItem('id').value.length));
			clearTimeout(waitInterval);
			waitInterval=window.setTimeout("etype=0;TabNews(rT,idn);if(getObject(rT+'_cnt').style.display == 'none')displayList(rT+'_cnt'); SetCookie(rT+'info',idn,10000000);SetCookie(rT+'_cntd','ture',10000000);",MouseDelayTime);
			}
		lis[iy].onmouseout=function(){if(getObject(rT+'_cnt').style.display != "none"&&className!="") return;clearTimeout(waitInterval);}
		} 
		if(etp==1){
		lis[iy].onmouseover=function(){getElementsByTagName('a')[0].blur();}
		lis[iy].onclick=function(){ 
			idn=parseInt(attributes.getNamedItem('id').value.substring(attributes.getNamedItem('id').value.length-1, attributes.getNamedItem('id').value.length));
			rT=attributes.getNamedItem('id').value.substring(0, attributes.getNamedItem('id').value.length-1);
			if(getObject(rT+'_cnt').style.display != "none"&&(idn==1&&(this.className=="tabactive1")||aw==attributes.getNamedItem('id').value)) return true;
				if(getObject(rT+'_cnt').style.display == "none"){ 
				displayList(rT+'_cnt');SetCookie(rT+'_cntd','ture',10000000);
				}
			etype=1;
			TabNews(rT,idn);
			SetCookie(rT+'info',idn,10000000);
			aw=attributes.getNamedItem('id').value;
			getElementsByTagName('a')[0].blur();
			return false;
			}}}
	}
} 

function ata(objid){
var as=objid.getElementsByTagName('a');
for(var i=0;i<as.length;i++){
as[i].target="_self";
}
}


function GetUrlParam(paramName){	//获取URL参数的函数
    var oRegex = new RegExp('[\?&]' + paramName + '=([^&]+)', 'i');
    var oMatch = oRegex.exec(window.location.search);
    if(oMatch && oMatch.length > 1)
        return oMatch[1];
    else
        return '';
}


function hideText(){
if(document.getElementsByTagName("arkoo:title").length==0){
var upu=GetUrlParam("username");
var upa=GetUrlParam("articleid");
getObject("closeit").innerHTML='<a href="http://cn.arkoo.com/diaryfiles/showpage.aspx?username='+upu+'&articleid='+upa+'" target="_blank">查看原文</a> <a href="tab.html" target="_self">×</a>';
}
}

var maxh=new Object();
//显示内容框
function displayList(oid){    
	var h = 0;  
	var objid=getObject(oid);
	      if(isNaN(parseInt(maxh[oid]))) var max_h = 210; // 容器的最大高度
		else 
			var max_h = maxh[oid];
	      var anim = function(){			
				    h += 50; // 每次递增50像素
				    if(h >= max_h){ 
		            objid.style.height = max_h + "px";; 
		            getObject('tab'+objid.attributes.getNamedItem('id').value).style.background="url(tab/images/tab_bgs.gif) 5px -113px no-repeat"; // 让图片标签改变背景	       
		            if(tt){window.clearInterval(tt);} 
				    }
				    else{ 
                objid.style.display="block"; 
                objid.style.height = h + "px";
				    }
		    }
		   	
			  var tt = window.setInterval(anim,2);  	
}

// 隐藏列表框
function hiddenList(objid){
       var h = objid.offsetHeight;
		   var anim = function(){
			     h -= 50; // 每次递减50像素
			     if(h <= 5){
	             objid.style.display="none"; 
		           getObject('tab'+objid.attributes.getNamedItem('id').value).style.background="url(tab/images/tab_bgs.gif) -14px -114px no-repeat"; 
		           if(tt){window.clearInterval(tt);}
		       }
		       else{
		           objid.style.height = h + "px";
		       }
		   }
		     
		   var tt = window.setInterval(anim,2); 
}

function showClassList(oid){
var objid=getObject(oid);
   if(objid.style.display == "none"){
	if(objid.getElementsByTagName("img").length==0)TabNews(oid.substring(0,oid.indexOf("_")),1);
       displayList(oid); // 显示内容框
	SetCookie(oid+'d',"ture",10000000);
   }
   else{
      if(isNaN(parseInt(maxh[oid]))){
         if(Browser.isFirefox){
            maxh[oid]=objid.offsetHeight;
      }
      else{
         maxh[oid]=objid.offsetHeight; // 内容容器的初始高度
          }
      }
      hiddenList(objid); // 隐藏内容框 
	SetCookie(oid+'d',"none",10000000);SetCookie(oid+'h',maxh[oid],10000000);
   }
}