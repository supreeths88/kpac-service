    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
	
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
		</style>
	</head>
	
	<div>
		<h1>Knowledge Package List</h1>
		<div class="grid-container">
			<table width="70%">
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Description</th>
				</tr>
		    	<c:forEach var="knowledgePackage" items="${knowledgePackages}">
				    <tr>
				    	<td class="grid-item" >${knowledgePackage.id}</td>
				    	<td class="grid-item" >${knowledgePackage.title}</td>
				    	<td class="grid-item" >${knowledgePackage.description}</td>
				    </tr>
		    	</c:forEach>
		    </table>
		</div>
   	</div> 