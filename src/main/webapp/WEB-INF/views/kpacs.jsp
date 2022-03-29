    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
	<head>
		<style>
			table, td, th {
			  border: 2px solid black;
			}
			
			table {
			  border-collapse: collapse;
			}
			
			td, th {
			  text-align: center;
			}
			
			tr:hover {
				background-color: coral;
			}
			
			select {
  				margin: 10px;
  				width: 150px;
 				padding: 5px 35px 5px 5px;
  				font-size: 11px;
				border: 2px solid #CCC;
			  	height: 34px;
  				-webkit-appearance: none;
  				-moz-appearance: none;
  				appearance: none;
			}
		</style>
	</head>
	<div>
		<h1>Add Knowledge Package</h1>
       	<form action="kpac" method="post">
		  <label for="title">Title:</label>
		  <input type="text" id="title" name="title" value="Title" required="required"><br>
		  
		  <label for="description">Description:</label>
		  <input type="text" id="description" name="description" value="Description" required="required"><br>
		  
		  <label for="date">Date:</label>
		  <input type="text" id="date" name="date" value="28-03-2022" required="required"><br>
		  
		  <input type="button" value="Save" onclick="this.form.submit()">
		</form> 
		<h1>Knowledge Package List</h1>
		
		<form action="kpacs" method="post">
		  <label for="filterByField">Filter By Field:</label>
		  <select id="filterByField" name="filterByField" required="required" >
				<option>Id</option>
				<option>Title</option>
				<option>Description</option>
				<option>Date</option>
		  </select>
		  
		  <label for="filterByValue">Filter By Value:</label>
		  <input type="text" id="filterByValue" name="filterByValue" value="FILTER VALUE" required="required"><br>
		  
		  <label for="sortByField">Sort By Field:</label>
		  <select id="sortByField" name="sortByField" required="required" >
				<option>Id</option>
				<option>Title</option>
				<option>Description</option>
				<option>Date</option>
		  </select>
		  
		  <label for="orderByValue">Order By Value:</label>
		  <select id="orderByValue" name="orderByValue" required="required" >
				<option>ASC</option>
				<option>DESC</option>
		  </select>
		  
		  <input type="button" value="Apply Filters" onclick="this.form.submit()">
		</form> 
		<div class="grid-container">
			<table width="70%">
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Description</th>
					<th>Date</th>
					<th>Action</th>
				</tr>
		    	<c:forEach var="knowledgePackage" items="${knowledgePackageList}"> 
				    <tr>
				    	<td class="grid-item" >${knowledgePackage.id}</td>
				    	<td class="grid-item" >${knowledgePackage.title}</td>
				    	<td class="grid-item" >${knowledgePackage.description}</td>
				    	<td class="grid-item" >${knowledgePackage.date}</td>
			    	 	<td class="grid-item" >
			    	 		<a href="kpac/delete/${knowledgePackage.id}">
			    	 			<i class="glyphicon glyphicon-trash"> </i>
			    	 		</a>
			    	 	</td>
				    </tr>
		    	</c:forEach>
		    </table>
		</div>
   	</div> 