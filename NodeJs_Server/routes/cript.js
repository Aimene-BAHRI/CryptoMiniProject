var express = require('express');
var router = express.Router();

/* Get /  */
router.get('/:name/:methode/:message/:key', function(req, res, next) {
  
  var PythonShell = require('python-shell');
  
  
  var options = {
    mode: 'text',
    pythonPath: '/usr/bin/python',
    args: [req.params["methode"], req.params["message"], req.params["key"]]
  };
  
  PythonShell.run('./python/' + req.params["name"] + ".py"  , options, function (err, results) {
    if (err) throw err;
    // results is an array consisting of messages collected during execution 
    res.send (results[0])
  });

  //res.send('respond with a resource');
});



// Post /
router.post('/', function(req, res, next) {
  
  console.log(req.body)

  if (req.body != null){
    
    var PythonShell = require('python-shell');
    
    var name = req.body.name
    var arg = [req.body.methode, req.body.message, req.body.key]
    if (req.body.methode == "get_key" ){
      name += "_keyGen"
      arg = [req.body.num]
    }
    
    var options = {
      mode: 'text',
      pythonPath: '/usr/bin/python',
      args: arg
    };
    
    PythonShell.run('./python/' + name + ".py"  , options, function (err, results) {
      if (err) throw err;
      // results is an array consisting of messages collected during execution 
      if(req.body.name == "Rsa"){
        key =""
        results.forEach(function(value){
          key += value + "\n"
        });
        console.log(key);
        res.send(key)
      }
        
      else
        res.send (results[0])
    });
  }
  else{
    res.send("{Reques ERROR}")
  }
});

module.exports = router;
