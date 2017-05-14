var express = require('express');
var router = express.Router();

/* Encripting Decripting  */
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

router.post('/', function(req, res, next) {
  
  console.log(req.body)

  if (req.body != null){
    
    var PythonShell = require('python-shell');
    
    
    var options = {
      mode: 'text',
      pythonPath: '/usr/bin/python',
      args: [req.body.methode, req.body.message, req.body.key]
    };
    
    PythonShell.run('./python/' + req.body.name + ".py"  , options, function (err, results) {
      if (err) throw err;
      // results is an array consisting of messages collected during execution 
      res.send (results[0])
    });
  }
  else{
    res.send("{Reques ERROR}")
  }
});

module.exports = router;
