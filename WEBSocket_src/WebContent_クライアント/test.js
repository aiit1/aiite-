    function end() {
    	window.open('about:blank','_self').close();
    	return false;
    }
    function show_block(val){
       str = "hoge" + val;
       if(document.getElementById(str).style.display == ""){
          document.getElementById(str).style.display = "none";
       }else{
          document.getElementById(str).style.display = "";
       }
    }

    function goLogin(param1) {
        document.form1.key.value = param1;
        document.form1.method = "post";
        document.form1.action = "/test/jp.test.framework.DispatcherServlet";
        document.form1.submit();
    }
    
    function goNext(param1) {
    	document.form1.key.value = param1;
        document.form1.method = "post";
        document.form1.action = "/test/DispatcherServlet";
        document.form1.submit();
        
    }