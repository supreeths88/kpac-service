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
			
			tr:hover {background-color: coral;}
			
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
		<h1>Add Knowledge Package Set</h1>
       	<form action="set" method="post">
       	
       	  <label for="id">Set Id:</label>
		  <input type="text" id="id" name="id" value="1" required="required"><br>
		  
		  <label for="title">Title:</label>
		  <input type="text" id="title" name="title" value="Title" required="required"><br>
		  
		  <label for="kpacId">kpacId:</label>
		  <select id="kpacId" name="kpacId" required="required">
			<c:forEach var="knowledgePackage" items="${knowledgePackageList}">
				<option>${knowledgePackage.id}</option>
            </c:forEach>
		  </select>
		  <br/>
		  <input type="button" value="Save" onclick="this.form.submit()">
		</form> 
		
		<h1>Knowledge Package Set List</h1>
		<form action="sets" method="post">
		  <label for="filterByField">Filter By Field:</label>
		  <select id="filterByField" name="filterByField" required="required" >
				<option>Id</option>
				<option>Title</option>
		  </select>
		  
		  <label for="filterByValue">Filter By Value:</label>
		  <input type="text" id="filterByValue" name="filterByValue" value="FILTER VALUE" required="required"><br>
		  
		  <label for="sortByField">Sort By Field:</label>
		  <select id="sortByField" name="sortByField" required="required" >
				<option>Id</option>
				<option>Title</option>
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
					<th>Knowledge Package Id</th>
					<th>Action</th>
				</tr>
		    	<c:forEach var="knowledgePackageSet" items="${knowledgePackageSets}">
				    <tr ondblclick="window.open('http://localhost:8080/kpac-service/set/${knowledgePackageSet.id}','_blank')">
				    	<td class="grid-item" >${knowledgePackageSet.id}</td>
				    	<td class="grid-item" >${knowledgePackageSet.title}</td>
				    	<td class="grid-item" >${knowledgePackageSet.kpacId}</td>
				    	<td class="grid-item" >
				    		<a href="set/delete/${knowledgePackageSet.id}">
				    			<i class="glyphicon glyphicon-trash"> </i>
							</a>
				    	</td>
				    </tr>
		    	</c:forEach>
		    </table>
		</div>
   	</div> 