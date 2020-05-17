/*Given an iterator with methods next() and hasNext(), 
create a wrapper iterator, PeekableInterface, which also implements peek().
peek shows the next element that would be returned on next()*/
 

class PeekingIterator : public Iterator {
private:
    int m_next;
    bool m_hasnext;
public:
	PeekingIterator(const vector<int>& nums) : Iterator(nums) {
	    m_hasnext = Iterator::hasNext();
	    if (m_hasnext) m_next = Iterator::next();
	}

	int peek() {
        return m_next;
	}

	int next() {
	    int t = m_next;
	    m_hasnext = Iterator::hasNext();
	    if (m_hasnext) m_next = Iterator::next();
	    return t;
	}

	bool hasNext() const {
	    return m_hasnext;
	}
};