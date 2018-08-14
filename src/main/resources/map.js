    function(){
        if(this.client!=undefined){
          if(this.client.employees!=undefined) {
        var codes = this.client.employees;
        Object.keys(codes).forEach(function(k){
            if(codes[k].userName=="@@username" && codes[k].age==@@age){
            emit(k, 1);
                }
        })
       }
     }   
   }