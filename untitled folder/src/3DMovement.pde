import peasy.*;


PeasyCam cam;

float angle = 0;
boolean rotate = true;

void setup() {

  cam = new PeasyCam(this, 500);

  size(1000, 600, P3D);


}

void draw() {
  lights();
  background(0);
  strokeWeight(5);
  stroke(0, 0, 255);
  line(-500, 0, 0, 500, 0, 0);
  stroke(0, 255, 0);
  line(0, -500, 0, 0, 500, 0);
  stroke(255);
  line(0, 0, -500, 0, 0, 500);

  //noStroke();
  drawAtom(new Atom(1), new Atom(6));


}

void drawAtom(Atom atomA, Atom atomB) {

  noStroke();
  float d = atomA.radius + atomB.radius - 0.09 * (atomA.electronegativity - atomB.electronegativity);
  //System.out.println(d);

  //atomA.x =d/2 + atomA.radius;
  //atomB.x = d/2 + atomB.radius;

  //rotateAtoms(atomA, atomB, d);
    atomA.x =(d + atomA.radius) * cos(angle);
    atomA.y =(d + atomA.radius) * sin(angle);

    atomB.x = (d + atomA.radius) * cos(angle);
    atomB.y = (d + atomB.radius) * tan(angle);


  noStroke();

  translate(atomA.x, atomA.y);
  fill(255, 0, 0);
  sphere(atomA.radius);
  translate(-atomA.x, -atomA.y);

 translate(-atomB.x, -atomA. y);
  fill(100);
  sphere(atomB.radius);
  translate(atomB.x, atomA.y);

  //translate(atomA.x+10, atomA.y+10);

  stroke(255);
  strokeWeight(8);
  beginShape(LINES);
  translate(atomA.x, atomA.y);
  vertex(0, 0);
  translate(-atomA.x, -atomA.y);

  translate(atomB.x, atomB.y);
  vertex(0, 0);
  translate(-atomB.x, -atomB.y);
  endShape();

  //line(atomA.x, atomA.y, atomA.z, atomB.x, atomB.y, atomB.z);

  //box();

  if (rotate == true) {
    angle += 0.01;
    System.out.print("Atom A x, y: " + atomA.x + ", ");
    System.out.println(atomA.y);
    System.out.print("Atom B x, y: " + atomB.x + ", ");
    System.out.println(atomB.y);
  }


}

void keyPressed() {
  if (rotate == true) {
    rotate = false;
  }
  else if (rotate == false) {
    rotate = true;
  }
}
