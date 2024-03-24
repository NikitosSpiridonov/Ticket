package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class AviaSoulsTest {
    @Test
    public void shouldSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 4000, 7, 9);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 12, 14);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "SPB", 3000, 11, 13);
        Ticket ticket5 = new Ticket("SPB", "UFA", 8000, 7, 13);
        Ticket ticket6 = new Ticket("MSK", "NSK", 9000, 8, 12);
        Ticket ticket7 = new Ticket("UFA", "SPB", 7000, 17, 22);
        Ticket ticket8 = new Ticket("MSK", "UFA", 6000, 21, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket2, ticket4, ticket1, ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNoTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 4000, 7, 9);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 12, 14);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "SPB", 3000, 11, 13);
        Ticket ticket5 = new Ticket("SPB", "UFA", 8000, 7, 13);
        Ticket ticket6 = new Ticket("MSK", "NSK", 9000, 8, 12);
        Ticket ticket7 = new Ticket("UFA", "SPB", 7000, 17, 22);
        Ticket ticket8 = new Ticket("MSK", "UFA", 6000, 21, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("SPB", "NSK");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 4000, 7, 9);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 12, 14);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "SPB", 3000, 11, 13);
        Ticket ticket5 = new Ticket("SPB", "UFA", 8000, 7, 13);
        Ticket ticket6 = new Ticket("MSK", "NSK", 9000, 8, 12);
        Ticket ticket7 = new Ticket("UFA", "SPB", 7000, 17, 22);
        Ticket ticket8 = new Ticket("MSK", "UFA", 6000, 21, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.search("MSK", "UFA");
        Ticket[] expected = {ticket8};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFewTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 4000, 1, 4);//2
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 2, 6);//3
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 3, 8);//4
        Ticket ticket4 = new Ticket("MSK", "SPB", 3000, 11, 12);//1
        Ticket ticket5 = new Ticket("SPB", "UFA", 8000, 7, 13);
        Ticket ticket6 = new Ticket("MSK", "NSK", 9000, 8, 15);
        Ticket ticket7 = new Ticket("UFA", "SPB", 7000, 17, 23);
        Ticket ticket8 = new Ticket("MSK", "UFA", 6000, 15, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket4, ticket1, ticket2, ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    public void shouldSortNoTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 4000, 1, 4);//2
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 2, 6);//3
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 3, 8);//4
        Ticket ticket4 = new Ticket("MSK", "SPB", 3000, 11, 12);//1
        Ticket ticket5 = new Ticket("SPB", "UFA", 8000, 7, 13);
        Ticket ticket6 = new Ticket("MSK", "NSK", 9000, 8, 15);
        Ticket ticket7 = new Ticket("UFA", "SPB", 7000, 17, 23);
        Ticket ticket8 = new Ticket("MSK", "UFA", 6000, 15, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("SPB", "MSK", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    public void shouldSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 4000, 1, 4);//2
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 2, 6);//3
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 3, 8);//4
        Ticket ticket4 = new Ticket("MSK", "SPB", 3000, 11, 12);//1
        Ticket ticket5 = new Ticket("SPB", "UFA", 8000, 7, 13);
        Ticket ticket6 = new Ticket("MSK", "NSK", 9000, 8, 15);
        Ticket ticket7 = new Ticket("UFA", "SPB", 7000, 17, 23);
        Ticket ticket8 = new Ticket("MSK", "UFA", 6000, 15, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("UFA", "SPB", comparator);
        Ticket[] expected = {ticket7};
        Assertions.assertArrayEquals(expected, actual);
    }
}