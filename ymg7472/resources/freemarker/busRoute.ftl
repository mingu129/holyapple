<!DOCTYPE html>
<html>
<head>
<META HTTP-EQUIV="refresh" CONTENT="20">
<style>
table {
  width:75%;
}
table, th, td {
  border: 1px solid white;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
#t01 tr:nth-child(even) {
  background-color: #eee;
}
#t01 tr:nth-child(odd) {
 background-color: #fff;
}
#t01 th {
  background-color: black;
  color: white;
}
#t01 td:last-child {
	background-color: white;
}
#t01 th:last-child {
	background-color: green;
}
</style>
</head>
<body>

<table id="t01">
  <tr>
    <th>${num}�� �뼱�� ���� ������ ���</th> 
    <th>������ġ</th> 
  </tr>
  <tr>
    <td><a href="#bang">���</a></td> 
  </tr>
  <#list busRouteInfo as i>
	  <tr>
		  <#if i.turnYn == "Y">
						  <#if where?seq_contains(i.stationSeq)>
							    <td><a name="bang">ȸ��<br><a href="http://localhost:4567/station/${num}/${i.stationId}"target="_self">${i.stationName}</a><br>${i.stationId}<br>${i.mobileNo}</td>	
							    <td style="background-color: green; color: white;">����:&nbsp;${name[where?seq_index_of(i.stationSeq)]}</td>
							    <#break>
						<#else>
							<td><a name="bang">ȸ��<br><a href="http://localhost:4567/station/${num}/${i.stationId}"target="_self">${i.stationName}</a><br>${i.stationId}<br>${i.mobileNo}</td>	
							<td></td>
						  </#if>

						  
					  
		   <#else>
					   	<#if where?seq_contains(i.stationSeq)>
							  	<td><a href="http://localhost:4567/station/${num}/${i.stationId}"target="_self">${i.stationName}</a><br>${i.stationId}<br>${i.mobileNo}</td>
							  	<td style="background-color: green; color: white;">����:&nbsp;${name[where?seq_index_of(i.stationSeq)]}</td>
						  	<#else>
							  	<td><a href="http://localhost:4567/station/${num}/${i.stationId}"target="_self">${i.stationName}</a><br>${i.stationId}<br>${i.mobileNo}</td>
							  	<td></td>
						  	</#if>

			</#if>
	  </tr>
  </#list>


</table>

</body>
</html>