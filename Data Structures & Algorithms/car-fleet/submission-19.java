class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < position.length; ++i) {
            double temp = (double) target - (double) position[i];
            cars.add(new Car(position[i], speed[i], (double) temp / (double) speed[i]));
        }

        cars.sort(Comparator.comparingInt(Car::position).reversed());

        Deque<Car> stack = new ArrayDeque<>();

        stack.push(cars.get(0));

        for (int i = 1; i < cars.size(); ++i) {
            if (cars.get(i).hours() > stack.peek().hours()) {
                stack.push(cars.get(i));
            }
        }

        return stack.size();
    }

    public record Car (int position, int speed, double hours) {}
}

