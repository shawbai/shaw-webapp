require.config({
    baseUrl: '../dist',
    shim:{
    	 'jquery':{
             exports: 'jquery'
         },
         'vue':{
             exports: 'vue'
         }
    },
    paths: {
    	'jquery' : "//cdn.bootcss.com/jquery/3.2.1/jquery.min",
    	'vue':"//cdn.bootcss.com/vue/2.3.4/vue.min.js"
    		
    }
});
