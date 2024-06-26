import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue;
    private Queue<String> orders;

    public Market() {
        this.queue = new LinkedList<>();
        this.orders = new LinkedList<>();
    }

    // Реализация методов QueueBehaviour
    /**
     * @param person
     */
    @Override
    public void addToQueue(String person) {
        queue.add(person);
        System.out.println(person + " добавлен в очередь.");
    }

    @Override
    public String removeFromQueue() {
        if (!queue.isEmpty()) {
            String person = queue.poll();
            System.out.println(person + " удалён из очереди.");
            return person;
        } else {
            System.out.println("Очередь пуста.");
            return "";
        }
    }

    // Реализация методов MarketBehaviour
    @Override
    public void placeOrder(String order) {
        orders.add(order);
        System.out.println("Заказ '" + order + "' размещён.");
    }

    @Override
    public String processOrder() {
        if (!orders.isEmpty()) {
            String order = orders.poll();
            System.out.println("Заказ '" + order + "' обработан.");
            return order;
        } else {
            System.out.println("Нет заказов для обработки.");
            return "";
        }
    }

    @Override
    public void update() {
        System.out.println("Обновление состояния магазина:");
        if (!queue.isEmpty()) {
            String person = removeFromQueue();
            String order = processOrder();
            if (!order.isEmpty()) {
                System.out.println(person + " получил заказ '" + order + "'.");
            } else {
                System.out.println(person + " ожидает обработки заказа.");
            }
        } else {
            System.out.println("Нет людей в очереди.");
        }
    }

    // Пример использования
    public static void main(String[] args) {
        Market market = new Market();
        market.addToQueue("Алексей");
        market.addToQueue("Мария");
        market.placeOrder("Яблоки");
        market.placeOrder("Хлеб");
        market.update();
        market.update();
        market.update();
    }
}
