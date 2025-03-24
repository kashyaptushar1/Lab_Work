#include<stdio.h>
#include<conio.h>
#include<graphics.h>

void main(){
    int gd = DETECT,gm;
    initgraph(&gd, &gm, "c:\\turboc3\\bgi");
    //Draw line
    line(100,100,200,200);
    //Draw circle
    circle(100,100,50);
    // for fill cicle
    circle(100,100,50);
    setfillstyle(SOLID_FILL,BLUE);
    floodfill(100,100,WHITE);
    // for draw trianle and fill
    line();
    line();
    line();
    setfillstyle(SOLID_FILL,RED);
    floodfill((x1+x2+x3)/3, (y1+y2+y3)/3,WHITE);
    // same as rectangle and quarta
    getch();
    closegraph();
}