<!DOCTYPE html>
<html>
<head>
<META HTTP-EQUIV="refresh" CONTENT="20">
<style>
table {
  width:100%;
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
<th>���� ���� ����</th>
</tr>
<#list stationArrivalInfo as i>
<tr>
<td>1��° ���� : ${i.plateNo1}<br>${i.predictTime1}���� ���� (${i.locationNo1}��° �� ������)<br>���� ȥ�����: ����</td>
</tr>
<#if i.locationNo2 != "">
<tr>
<td>2��° ���� : ${i.plateNo1}<br>${i.predictTime2}���� ���� (${i.locationNo2}��° �� ������)<br>���� ȥ�����: ����</td>
</tr>
<#else>
<tr>
<td>2��° ���� : �����</td>
</tr>
</#if>
</#list>

</table>

</body>
</html>