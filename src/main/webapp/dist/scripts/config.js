require.config({
    baseUrl: '../dist',
    shim:{
    	 'jquery':{
             exports: 'jquery'
         }
    },
    paths: {
    	'jquery' : "//cdn.bootcss.com/jquery/3.2.1/jquery.min"
    }
});

require([ 'scripts/test' ], function(test) {
})