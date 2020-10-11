<!DOCTYPE html>
<html>
<head>
<style>
table {
  width:75%;
}
table, th, td {
  border: 1px solid black;
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
</style>
</head>
<body>


<table id="t01">
  <tr>
    <th>${num}�� �뼱 ��� �˻� ���</th> 
  </tr>
  <#list busInfo as i>
  <tr>
    <td>��������: ${i.districtCd}&nbsp;��������: ${i.regionName}<br>�뼱 ���̵�: ${i.routeId}&nbsp;�뼱 ��ȣ: ${i.routeName}&nbsp;�뼱 ����: ${i.routeTypeName}&nbsp;<a href="http://localhost:4567/route/${i.routeId}"target="_self">�뼱 ���� Ȯ���ϱ�</a></td>
  </tr>
  </#list>


</table>

</body>
</html>