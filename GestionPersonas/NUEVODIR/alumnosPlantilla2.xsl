<?xml version="1.0" encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match='/'>
   <html><xsl:apply-templates /></html>
 </xsl:template>
 <xsl:template match='listadealumnos'>
    <head><title>LISTADO DE ALUMNOS</title></head>
    <body> 
    <h1>LISTA DE ALUMNOS</h1>
    <table border='1'>
    <tr><th>DNI</th><th>Nombre</th><th>Apellidos</th><th>Direccion</th><th>CP</th><th>Provincia</th><th>Telefono</th><th>E-mail</th><th>Edad</th></tr>
      <xsl:apply-templates select='alumno' />
    </table>
    </body>
 </xsl:template>
 <xsl:template match='alumno'>
   <tr><xsl:apply-templates /></tr>
 </xsl:template>
 <xsl:template match='dni|nombre|apellidos|direccion|CP|provincia|telefono|email|edad'>
   <td><xsl:apply-templates /></td>
 </xsl:template>
</xsl:stylesheet>