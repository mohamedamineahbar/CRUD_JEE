<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String msg = (String) request.getAttribute("msg");
	if(msg==null){
		msg="";
	}
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>CRUD JSP</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: white;
            padding: 25px;
            width: 380px;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0,0,0,0.15);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .input-group {
            margin-bottom: 15px;
        }

        .input-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: 600;
        }

        .input-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        .btn-box {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            gap: 10px;
        }

        .btn {
            flex: 1;
            padding: 10px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
            color: white;
        }

        .search { background: #4285f4; }
        .add { background: #34a853; }
        .delete { background: #ea4335; }
        .update { background: #fbbc05; color: black; }

        .btn:hover { opacity: 0.9; }
    </style>
</head>

<body>
	<h1><%= msg %></h1>
    <div class="container">
        <h2>CRUD JSP</h2>

        <form action="Crud">

            <div class="input-group">
                <label>Ref</label>
                <input type="text" name="ref" >
            </div>

            <div class="input-group">
                <label>Title</label>
                <input type="text" name="title" >
            </div>

            <div class="input-group">
                <label>Prix</label>
                <input type="number" name="prix" step="0.01">
            </div>

            <div class="input-group">
                <label>Qte</label>
                <input type="number" name="qte">
            </div>

            <div class="btn-box">
                <button formmethod="get" value="recherche" class="btn search">Recherche</button>
                <button formmethod="post" value="ajout" class="btn add">Ajouter</button>
                <button formmethod="delete" value="delete" class="btn delete">Delete</button>
                <button formmethod="PUT" value="update" class="btn update">Update</button>
            </div>
        </form>

        <br>

    </div>



</body>
</html>