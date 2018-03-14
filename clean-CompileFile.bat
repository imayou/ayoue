::@echo off

for /r %cd% %%a in (.) do @if exist %%a\target rd /s /q %%a\target
for /r %cd% %%a in (.) do @if exist %%a\.settings rd /s /q %%a\.settings
::for /r %cd% %%a in (.) do @if exist %%a\bin rd /s /q %%a\bin

for /f "delims=" %%i in ('dir /b /a-d /s "*.project"') do del %%i
for /f "delims=" %%i in ('dir /b /a-d /s ".classpath"') do del %%i
for /f "delims=" %%i in ('dir /b /a-d /s "*.war"') do del %%i
for /f "delims=" %%i in ('dir /b /a-d /s "*.jar"') do del %%i
for /f "delims=" %%i in ('dir /b /a-d /s "*.prefs"') do del  %%i

pause...