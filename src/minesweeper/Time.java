/* time class for java swing minesweeper clone. holds name and time
 * David De Martin
 * 25/5/2021
*/

package src.minesweeper;

public class Time {
    public int time;
    public String name;

    public Time(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }
    public int getTime() {
        return time;
    }
}
