from Queue import *

def test_EmptyQueue():
	q = Queue()
	assert q.is_empty()

def test_QueueHead():
	q = Queue()
	q.insert(5)
	assert q.peekHead() is 5
	
def test_QueueRemove():
	q = Queue()
	q.insert(6)
	assert q.remove() is 6

def test_FIFOQueue():
	q = Queue()
	q.insert(4)
	q.insert(7)
	assert q.remove() is 4

	q.insert(2)
	assert q.remove() is 7
	assert q.remove() is 2

def test_PriorityQueueInsertion():
	pq = PriorityQueue()
	pq.insert(3)
	pq.insert(7)
	pq.insert(8)
	assert pq.peekHead() is 8

def test_PriorityQueueRemoval():
	pq = PriorityQueue()
	pq.insert(3)
	pq.insert(7)
	pq.insert(8)
	pq.insert(2)
	assert pq.remove() is 8
	assert pq.remove() is 7
	assert pq.remove() is 3
	assert pq.remove() is 2