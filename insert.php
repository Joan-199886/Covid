<?php

    $hostname='localhost';
    $database='uusuarios';
    $username='root';
    $password='';
   // $connection = mysqli_connect("localhost","root","","uusarios");
   $conexion= mysqli_connect($hostname,$username,$password,$database);
    
    $nombre=$_POST["nombre"];
    $apellido=$_POST['apellido'];
    $numero_documento=$_POST['numero_documento'];
    $direccion=$_POST['direccion'];
    $telefono=$_POST['telefono'];
    $estado=$_POST['estado'];
    $password=$_POST['password'];
    $correo=$_POST['correo'];
     
   /*  $sql = "INSERT INTO `usuarios`(nombre,apellido, numero_documento, direccion, telefono, estado, password, correo) 
     VALUES('$nombre','$apellido','$numero_documento','$direccion',$telefono','$estado',$password','$correo',)";
     */
     $sql= "INSERT INTO `usuarios`(`Nombre`, `apellido`, `numero_documento`, `direccion`, `telefono`, `estado`, `password`, `correo`) 
    VALUES ('$nombre','$apellido','$numero_documento','$direccion','$telefono','$estado','$password','$correo')";
     
     $result = mysqli_query($conexion,$sql);
     
     if($result){
         echo "Data Inserted";
        
     }
     else{
         echo "Failed";
     }
     mysqli_close($conexion);
     
          
    
    


?>