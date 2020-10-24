#include <iostream>

class DLLNode
{
public:
	DLLNode()
	{
		next = prev = 0;
	}
	DLLNode(const int& el, DLLNode* n = 0, DLLNode* p = 0)
	{
		info = el; next = n; prev = p;
	}

	int info;
	DLLNode* next, * prev;
};

class DoublyLinkedList
{
public:
	DoublyLinkedList()
	{
		head = tail = 0;
	}
	void addToDLLHead(const int&);
	int deleteFromDLLHead();
	void addToDLLTail(const int&);
	int deleteFromDLLTail();
	void printout();
protected:
	DLLNode* head, * tail;
};

