#include "dll_specification.h"
using namespace std;
void DoublyLinkedList::addToDLLHead(const int& el)
{
	if (head != 0)
	{
		head = new DLLNode(el, head, 0);
		head->next->prev = head;
	}
	else head = tail = new DLLNode(el);
}

int DoublyLinkedList::deleteFromDLLHead()
{
	int el = head->info;
	if (head == tail)
	{
		delete head;
		head = tail = 0;
	}
	else
	{
		head = head->next;
		delete head->prev;
		head->prev = 0;
	}
	return el;
}
void DoublyLinkedList::addToDLLTail(const int& el)
{
	if (tail != 0)
	{
		tail = new DLLNode(el, 0, tail);
		tail->prev->next = tail;
	}
	else head = tail = new DLLNode(el);
}

int DoublyLinkedList::deleteFromDLLTail()
{
	int el = tail->info;
	if (head == tail)
	{
		delete head;
		head = tail = 0;
	}
	else
	{
		tail = tail->prev;
		delete tail->next;
		tail->next = 0;
	}
	return el;

}

void DoublyLinkedList::printout()
{
	DLLNode* tmp = head;
	for (head; head->next != 0; head = head->next)
		cout << head->info << " ";
	cout << head->info;
	head = tmp;
}