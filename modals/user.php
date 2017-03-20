<?php 
Class User {

    private $_db;
    function __construct($db_data){
        $this->_db = $db_data;
    }
    public function sign_in($uname,$pass){

        try {
            $query = $this->_db->prepare('SELECT * FROM user WHERE Username=:uname AND Password=:pass');
            $query->execute(array(':uname'=>$uname,':pass'=>$pass));
            $r=$query->fetch(PDO::FETCH_ASSOC);
            $_SESSION['uname']=$r['Username'];
            $_SESSION['pass']=$r['Password'];
            $_SESSION['position']=$r['position'];
            
            return true;            
        } catch (PDOException $e) {
            return $e->getMessage();  
        }
    }
    public function is_not_logged_in() {
        if(isset($_SESSION['pass'], $_SESSION['uname']) && !empty($_SESSION['uname']) && !empty($_SESSION['pass'])) {
            return false;
        } else {
            return true;
        }
    }
    public function is_logged_in() {
       if(isset($_SESSION['pass'], $_SESSION['uname']) && !empty($_SESSION['uname']) && !empty($_SESSION['pass'])) {
            return true;
        } else {
            return false;
        }
    }
    public function sign_out(){
        session_destroy();
        return true;
    }
    public function enter_readings($level,$parent,$level_index,$home,$quality,$quantity){
        try{
            $query1 = $this->_db->prepare('UPDATE nodes SET quality=:quality,quantity=:quantity WHERE level=:level AND level_index=:level_index');
            $query1->execute(array(':quality'=>$quality,':quantity'=>$quantity,':level'=>$level,':level_index'=>$level_index));
            $query1->rowCount();
            return true;

        }catch (PDOException $e) {
            return $e->getMessage();  
        }
    }
  
    
}
?>