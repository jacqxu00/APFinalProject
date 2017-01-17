# Conservation of Energy AsimulaXuon
Jacqueline Xu and Asim Kapparova

<h2> Description </h2>
<p> This program is a simulation of the Law of Conservation of Energy through the typical “roller coaster problem,” using a skater in a skate park. This project idea was inspired by <a href="https://phet.colorado.edu/en/simulation/energy-skate-park-basics"> PhET Simulations Energy Skate Park </a>. In this simulation, the skater will follow a track at a velocity based on its translational kinetic energy. As with most basic conservation of energy simulations, rotational kinetic energy (kinetic energy from rotating objects) is ignored. </p>

<h2> Physics </h2>
<p> The physics behind the program is pretty simple to understand. The total energy in a system will always remain the same. This total energy is comprised of potential energy (based on object height), kinetic energy (based on object velocity), and thermal energy (based on object angle of motion and total distance traveled). The simulation stores the total energy of the system before the object moves. From then on, it figures out the potential energy (based on object height) and the thermal energy based on the object's angle of motion and distance traveled (found by approximating using the object's previous position and current position). The simulation uses this information to determine the object's kinetic energy, and from that, its velocity. This velocity and the equation of the track is used to determine the object's future position. </p>

<h2> Features </h2>
<p> The user can manually:
	<ul>
	  <li>choose a skate track</li>
	  <li>edit the mass of the skater </li>
	  <li>edit the acceleration by gravity </li>
	  <li>edit the coefficient of friction </li>
	  <li>pause/play the simulation </li>
	  <li>reset the simulation </li>
	</ul>
</p>
<p> The simulation will:
	<ul>
	  <li>determine the skater's velocity based on its energy </li>
	  <li>determine the skater's position </li>
	  <li>display bar graphs of the skater energy levels in real time </li>
	  <li>display the object's properties/variables in real time </li>
	</ul>
</p>

<h2> Unresolved Bugs </h2>
<p>
	<ul>
		<li>sometimes the GUI misplaces the components for no reason, the user just has to close and re-run the program</li>
		<li>the user also should not be able change tracks after the skater has started moving. We tried to remedy this by putting the buttons where Java will repaint it, so it "disappears," but the user technically still can press the buttons</li>
		<li>if there is friction present, the skater will hit 0 velocity before it reaches the ground level. We couldn't figure this out because thermal energy has to be scaled perfectly so that it equals the total energy when potential and kinetic energy equals zero. Unfortunately, this requires a level of calculus thtat we could not figure out. So at a certain point, the skater will disappear because it has an undefined value for velocity. This is also a problem if you change friction after the skater has left its original location because thermal energy is calculated by adding it energy each step of the way. </li>
		<li>after the user presses "Reset," all the values are set back to their defaults, and they can't be unchanged.</li>
	</ul>
</p>

<h2> How To Compile/Run </h2>
<p> In Terminal, type the following:
	<ol>
	  <li>javac Sim.java </li>
	  <li>java Sim </li>
	</ol>
</p>

<h2> How To Use Program </h2>
<p> 
	<ol>
	  <li>Choose a track</li>
	  <li>Set your variables</li>
	  <li>Press Go</li>
	  <li>Change your variables however you like while the code is running</li>
	  <li>Press Stop to pause</li>
	  <li>Press Reset to start the skater at its original location</li>
	</ol>
</p>
